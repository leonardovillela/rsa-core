package br.com.villela.rsacoreapi.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private Properties properties = new Properties();
    private InputStream inputStream;

    private String dirKeyName;
    private String publicKeyFileName;
    private String privateKeyFileName;

    public Config() throws IOException {
        inputStream = new FileInputStream("config.properties");
        properties.load(inputStream);

        this.dirKeyName = properties.getProperty("dirKeyName");
        this.publicKeyFileName = properties.getProperty("publicKeyFileName");
        this.privateKeyFileName = properties.getProperty("privateKeyFileName");
    }

    public String getDirKeyName() {
        return dirKeyName;
    }

    public String getPublicKeyFileName() {
        return publicKeyFileName;
    }

    public String getPrivateKeyFileName() {
        return privateKeyFileName;
    }
}
