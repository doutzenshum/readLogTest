package com.readlogDao;

import java.util.List;
import java.util.Map;

import com.equipment.Log;

public interface LogDao {
	
	public Map<String,List<Log>> sortByPid() throws Exception;
	
	public void findByDate(String date,Map<String, List<Log>> map) throws Exception;
	
	public void showAllLog(Map<String,List<Log>> map);
	
	public void showLogByPid(String pid,Map<String, List<Log>> map) throws Exception;
}
