package br.com.villela.rsacore.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KeysConfigLoader {

    public static final String CONFIG_PROPERTIES_FILE = "config.properties";
    public static final String CUSTOM_PATH_TO_KEY = "pathToKey";

    public KeysConfig load() {
        return defaultConfigWasOverwritten() ? loadCustomConfig() : loadDefaultConfig();
    }

    private boolean defaultConfigWasOverwritten() {
        String pathToKey = System.getProperty(CUSTOM_PATH_TO_KEY);
        return pathToKey != null && !pathToKey.isEmpty();
    }

    private KeysConfig loadCustomConfig() {
        String pathToKey = System.getProperty("pathToKey");
        String keyDirPath = extractCustomDirKeysPath(pathToKey);

        return createCustomConfig(pathToKey, keyDirPath);
    }

    private KeysConfig loadDefaultConfig() {
        try {
            return loadConfigFromPropertiesFile();
        } catch (IOException e) {
            throw new LoadConfigFromPropertiesFailureException();
        }
    }

    private KeysConfig loadConfigFromPropertiesFile() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES_FILE);
        properties.load(resourceAsStream);

        String keyDirPath, publicKeyFileName, privateKeyFileName;
        keyDirPath = getKeyDirNameFullPath(properties.getProperty("dirKeyName"));
        publicKeyFileName = properties.getProperty("publicKeyFileName");
        privateKeyFileName = properties.getProperty("privateKeyFileName");

        return new KeysConfig(keyDirPath, publicKeyFileName, privateKeyFileName);
    }

    private String getKeyDirNameFullPath(String keyDirName) {
        return System.getenv().get("HOME") + "/" + keyDirName + "/";
    }

    private KeysConfig createCustomConfig(String pathToKey, String keyDirPath) {
        String keyName = extractCustomKeyName(pathToKey);
        if (pathToKey.endsWith(".pub"))
            return new KeysConfig(keyDirPath, keyName, null);
        else
            return new KeysConfig(keyDirPath, null, keyName);
    }

    private String extractCustomDirKeysPath(String pathToKey) {
        int lastIndexOfSlash = pathToKey.lastIndexOf("/");
        return pathToKey.substring(0, lastIndexOfSlash);
    }

    private String extractCustomKeyName(String pathToKey) {
        int lastIndexOfSlash = pathToKey.lastIndexOf("/");
        return pathToKey.substring(lastIndexOfSlash + 1, pathToKey.length());
    }
}
