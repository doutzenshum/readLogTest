package com.equipment;

public class Log {

	private String date;
	private String pid;
	private String context;

	public Log(String date, String pid, String context) {
		super();
		this.date = date;
		this.pid = pid;
		this.context = context;
	}
	
	public Log() {
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "Log"+" [日期：" + date + ", 线程编号：" + pid + ", 内容：" + context + "]";
	}
	
	

}
