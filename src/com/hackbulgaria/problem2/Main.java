package com.hackbulgaria.problem2;

public class Main {

	public static void main(String[] args) {
		ConsoleLogger log = new ConsoleLogger();
		FileLogger fileLogger = new FileLogger("D:\\log.txt");
		HTTPLogger httplogger = new HTTPLogger("https://susi.uni-sofia.bg");
		
		log.log(0, "Hello World");
		fileLogger.log(0, "Hello World");
		httplogger.log(0, "Hello World");
	}
}
