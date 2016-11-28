package br.com.villela.rsacore.key.reader;

import br.com.villela.rsacore.config.KeysConfig;
import br.com.villela.rsacore.config.KeysConfigLoader;
import br.com.villela.rsacore.key.Key;
import br.com.villela.rsacore.key.KeyPair;

import java.io.IOException;

public class KeysPairFileReader {

    public static KeyPair readKeysFromFiles(KeysConfigLoader keysLoader) throws IOException {
        KeysConfig keysConfig = keysLoader.load();

        Key publicKey = KeyFileReader.read(keysConfig.getPublicKeyFilePath());
        Key privateKey = KeyFileReader.read(keysConfig.getPrivateKeyFilePath());
        return new KeyPair(publicKey, privateKey);
    }
}
