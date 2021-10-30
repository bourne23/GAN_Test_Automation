package com.moneygaming.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);

    private static Properties properties;
    static {
        try {
            String path = "configuration.properties";
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
           logger.info("Exception occurred: "+ e);
        }
    }

    /**
     * Method to invoke a property
     * @param keyName
     * @return
     */
    public static String getProperty(String keyName) {    //using this method, when the class is loaded only once
        return properties.getProperty(keyName);
    }
}

