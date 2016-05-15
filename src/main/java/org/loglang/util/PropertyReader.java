package org.loglang.util;

import java.io.*;
import java.util.Properties;

/**
 * Created by liumiao on 16-5-14.
 */
public class PropertyReader {
    private String filename;
    private Properties properties;

    public PropertyReader(String filename) throws IOException {
        this.filename = filename;
        read();
    }

    private void read() throws IOException {
        this.properties = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(this.filename));
        this.properties.load(in);
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public Character[] getCharacters(String key) {
        char[] chars = properties.getProperty(key).toCharArray();
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            characters[i] = chars[i];
        }
        return characters;
    }

    public String[] getArray(String key, String sep) {
        return properties.getProperty(key).split(sep);
    }
}
