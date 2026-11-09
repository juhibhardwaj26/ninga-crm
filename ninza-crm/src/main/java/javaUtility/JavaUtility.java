package javaUtility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
	public static String getCurrentTime() {
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss_ddMMMyyyy"));
		return time;
	}
}
