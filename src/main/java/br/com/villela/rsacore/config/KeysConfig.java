package br.com.villela.rsacore.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class KeysConfig {
    private String keyDirPath;
    private String publicKeyFileName;
    private String privateKeyFileName;

    public KeysConfig(String keyDirPath, String publicKeyFileName, String privateKeyFileName) {
        this.keyDirPath = keyDirPath;
        this.publicKeyFileName = publicKeyFileName;
        this.privateKeyFileName = privateKeyFileName;
    }

    public Path getPublicKeyFilePath() {
        return this.publicKeyFileName != null ? Paths.get(this.keyDirPath, this.publicKeyFileName) : null;
    }

    public Path getPrivateKeyFilePath() {
        return this.privateKeyFileName != null ? Paths.get(this.keyDirPath, this.privateKeyFileName) : null;
    }

    public Path getKeyDirPath() {
        return Paths.get(keyDirPath);
    }
}
