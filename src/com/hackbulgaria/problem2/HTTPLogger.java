package com.hackbulgaria.problem2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.net.ssl.HttpsURLConnection;

public class HTTPLogger implements MyLogger{

	private HttpsURLConnection conn;
	private final String USER_AGENT = "Mozilla/5.0";
	private String url;
	private TimeZone tz;
	private DateFormat df;
	
	
	public HTTPLogger(String url){
		this.url = url;
		tz = TimeZone.getTimeZone("UTC");
		df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		df.setTimeZone(tz);
	}

	@Override
	public void log(int level, String message) {
		URL obj;
		try {
			obj = new URL(this.url);
			conn.setRequestMethod("POST");
			conn = (HttpsURLConnection) obj.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setDoOutput(true);
		conn.setDoInput(true);

		// post request
		try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream());) {
			dos.writeBytes(Messages.values()[level] + "::" + df.format(new Date()) + "::" + message);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
