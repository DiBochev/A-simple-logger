package com.hackbulgaria.problem2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FileLogger implements MyLogger{
	
	private String path;
	private TimeZone tz;
	private DateFormat df;
	
	public FileLogger(String path){
		this.path = path;
		tz = TimeZone.getTimeZone("UTC");
		df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		df.setTimeZone(tz);
	}

	@Override
	public void log(int level, String message) {
		if (level < 0 || level > 2) throw new IllegalArgumentException();
		try(PrintWriter	out = new PrintWriter(new BufferedWriter(new FileWriter(this.path, true)));) {
			out.println(Messages.values()[level] + "::" + df.format(new Date()) + "::" + message);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
