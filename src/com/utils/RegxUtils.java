package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.equipment.Log;

public class RegxUtils {

	private static final String REGX = "(\\d{4})-(\\d{2}|\\d{1})-(\\d{2}|\\d{1}) (\\d{2}):(\\d{2}):(\\d{2}),(\\d{3}) ([\\s\\S]{1,15})   ([\\s\\S]*)";

	public static Log getLog(String str) {

		Pattern p = Pattern.compile(REGX);
		Matcher m = p.matcher(str);
		if (m.find()) {
			Log log = new Log();
			log.setDate(m.group(1) + "-" + m.group(2) + "-" + m.group(3) + " " + m.group(4) + ":" + m.group(5) + ":"
					+ m.group(6) + " " + m.group(7));
			log.setPid(m.group(8).replace("[", "").replace("]", "").trim());
			log.setContext(m.group(9));
			return log;
		}
		return null;
	}

}
