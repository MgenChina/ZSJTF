package com.netty.utils;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	private static Logger logger;

	private static String filePath = "config/log4j.properties";

	private static boolean flag = false;

	public Log() {
		if (flag == false)
			Log.getPropertyFile();
	}

	private static synchronized void getPropertyFile() {
		 logger = Logger.getLogger("JTF");
//		logger = Logger.getRootLogger();
		PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
		flag = true;
	}

	private static void getFlag() {
		if (flag == false)
			Log.getPropertyFile();
	}

	public static void logInfo(String message) {
		Log.getFlag();
		logger.info(message);
	}
	
	public static void logDebug(String message) {
		Log.getFlag();
		logger.debug(message);
	}

	public static void logError(String message) {
		Log.getFlag();
		logger.error(message);
	}

	public static void logWarn(String message) {
		Log.getFlag();
		logger.warn(message);
	}
}
