package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.config.Constants;

public class PropertyUtility {
	/**
	 * This method will open Header.Properties and return value associate with
	 * key
	 * 
	 * @param key
	 * @return value in form of{@code String}
	 */
	public static String getProperty(String key,String propertiesFilepath) {
		String value = null;
		FileInputStream fis;
		
		try {
			fis = new FileInputStream(propertiesFilepath);
			Properties prop= new Properties();
			prop.load(fis);
					value = prop.getProperty(key);
		} catch (IOException e) {
			System.out.println("Unable to load Properties File");
			e.printStackTrace();
		}
		return value;
											}
	}