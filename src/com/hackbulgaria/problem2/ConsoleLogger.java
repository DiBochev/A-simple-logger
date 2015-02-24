package com.hackbulgaria.problem2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ConsoleLogger implements MyLogger {
	
	private TimeZone tz;
	private DateFormat df;
	
	public ConsoleLogger() {
		tz = TimeZone.getTimeZone("UTC");
		df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		df.setTimeZone(tz);
	}
	

	@Override
	public void log(int level, String message) {
		if (level < 0 || level > 2) {
			throw new IllegalArgumentException();
		}
		System.out.println(Messages.values()[level] + "::" + df.format(new Date()) + "::" + message);

	}

}
