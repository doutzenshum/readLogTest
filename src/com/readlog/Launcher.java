package com.readlog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.equipment.Log;
import com.readlogDaoImpl.LogDaoImpl;
import com.utils.DirectUtils;

public class Launcher {
	public static void main(String[] args) throws Exception {
		Map<String, List<Log>> map = new LogDaoImpl().sortByPid();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		String line = null;
		String command = null;
		String[] params = null;
		DirectUtils.showDirect();
		while (!"exit".equals(line = reader.readLine())) {
			if (line == null) {
				continue;
			}
			
			String[] elems = line.split(" ");
			command = elems[0];
			if (elems.length > 1) {
				params = Arrays.copyOfRange(elems, 1, elems.length);
			}
			BaseCommand.execute(command, params, map);
			DirectUtils.showDirect();
		}
	}

}
