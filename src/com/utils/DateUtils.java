package com.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

public class DateUtils {

	private static final String[] DATE_FORMAT = { "yyyy", "yyyy-MM", "yyyy-MM-dd", "yyyy-MM-dd HH", "yyyy-MM-dd HH:mm",
			"yyyy-MM-dd HH:mm:ss" };

	private static final int[] DATE_TYPE = { Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY,
			Calendar.MINUTE, Calendar.SECOND };

	public static String getLogDate(String date) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = null;
		StringTokenizer st = new StringTokenizer(date.replace(":", "-").replace(" ", "-"), "-");
		List<String> list = new ArrayList<>();
		while (st.hasMoreElements()) {
			list.add(st.nextToken());
		}
		if (list.size() > 0 && list.size() <= DATE_FORMAT.length) {
			sdf = new SimpleDateFormat(DATE_FORMAT[list.size() - 1]);
		} else {
			return "输入不合规范！";
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.size() > DATE_TYPE.length) {
				return "输入不合规范！";
			}
			try {
				if (DATE_TYPE[i] == 2) {
					calendar.set(DATE_TYPE[i], Integer.parseInt(list.get(i)) - 1);//注意,Calendar对象默认一月为0  
					continue;
				} 
				
				calendar.set(DATE_TYPE[i], Integer.parseInt(list.get(i)));
			} catch(Exception e) {
				System.out.println("只能输入数字!");
			}
			
		}
		return sdf.format(calendar.getTime());

	}
}
