package org.example.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream(
                "src/test/resources/config.properties"
            );
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("config.properties not found!", e);
        }
    }

    public static String getBaseUrl() { return properties.getProperty("base.url"); }
    public static String getBasePath() { return properties.getProperty("base.path"); }
    public static String getUsername() { return properties.getProperty("username"); }
    public static String getPassword() { return properties.getProperty("password"); }
    public static String getEnv() { return properties.getProperty("env"); }
    public static String getApiKey() { return properties.getProperty("api.key"); }
}
