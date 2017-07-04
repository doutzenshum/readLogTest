package com.readlogDaoImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import com.equipment.Log;
import com.readlogDao.LogDao;
import com.utils.RegxUtils;

public class LogDaoImpl implements LogDao {

	@Override
	public Map<String, List<Log>> sortByPid() throws Exception {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(new FileInputStream("log/idea.log"), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String line;
		List<Log> listLog = new ArrayList<>();
		Map<String, List<Log>> mapLog = new LinkedHashMap<>();
		while ((line = br.readLine()) != null) {
			Log log = RegxUtils.getLog(line);
			listLog.add(log);
		}
		for (Log log : listLog) {
			if (!mapLog.containsKey(log.getPid())) {
				List<Log> list = new ArrayList<>();
				list.add(log);
				mapLog.put(log.getPid(), list);
			} else {
				mapLog.get(log.getPid()).add(log);
			}
		}
		br.close();
		isr.close();
		return mapLog;
	}

	@Override
	public void findByDate(String date, Map<String, List<Log>> map) throws Exception {
		// TODO Auto-generated method stub
		List<Log> list = new ArrayList<>();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			List<Log> logList = map.get(key);
			for (Log log : logList) {
				if (log.getDate().contains(date)) {
					list.add(log);
				}
			}
		}
		for (Log log : list) {
			System.out.println("日期：" + log.getDate() + "\t日志内容：" + log.toString());
		}
		System.out.println("一共" + list.size() + "条记录");
	}

	@Override
	public void showAllLog(Map<String, List<Log>> map) {
		// TODO Auto-generated method stub
		Set<String> keys = map.keySet();
		int i = 0;
		for (String key : keys) {
			List<Log> list = map.get(key);
			for (Log log : list) {
				System.out.println("线程编号：" + key + "\t" + log.toString());
				i++;
			}
		}
		System.out.println("一共" + i + "条记录");
	}

	@Override
	public void showLogByPid(String pid, Map<String, List<Log>> map) throws Exception {
		// TODO Auto-generated method stub
		List<Log> list = map.get(pid);
		if (list != null) {
			for (Log log : list) {
				System.out.println(log);
			}
		} else {
			System.out.println("不存在此PID！");
		}
		if (list != null) {
			System.out.println("一共" + list.size() + "条记录");
		}

	}
}
