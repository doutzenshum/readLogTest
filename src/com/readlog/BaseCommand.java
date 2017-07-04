package com.readlog;

import java.util.List;
import java.util.Map;

import com.equipment.Log;
import com.readlogDaoImpl.LogDaoImpl;
import com.utils.DateUtils;

public class BaseCommand {

	public static final ThreadLocal<LogDaoImpl> THREAD_IMPL = new ThreadLocal<>();

	public static void execute(String command, String[] params, Map<String, List<Log>> map) throws Exception {
		LogDaoImpl impl = THREAD_IMPL.get();
		if (impl == null) {
			impl = new LogDaoImpl();
			THREAD_IMPL.set(impl);
		}
		switch (command) {
		case "1":
			THREAD_IMPL.get().showAllLog(map);
			break;
		case "2":
			if (params != null) {
				THREAD_IMPL.get().showLogByPid(params[0], map);
			} else {
				System.out.println("格式不正确!");
			}
			break;
		case "3":
			StringBuffer date = new StringBuffer();
			if (params != null) {
				for (String d : params) {
					date.append(d + " ");
				}
			}
			THREAD_IMPL.get().findByDate(DateUtils.getLogDate(date.toString()), map);
			break;
		default:
			break;
		}
	}
}
