package br.com.villela.rsacore.key.reader;

import br.com.villela.rsacore.key.Key;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;

public class KeyFileReader {

    public static Key read(Path keyPath) throws IOException {
        String fileContent = Files.lines(keyPath).reduce(String::concat).orElse("");
        return extractKey(fileContent);
    }

    private static Key extractKey(String publicKeyFileContent) {
        int indexOfToken = publicKeyFileContent.indexOf("|");
        String exponent = publicKeyFileContent.substring(0, indexOfToken);
        String productOfPrimes = publicKeyFileContent.substring(indexOfToken + 1, publicKeyFileContent.length());
        return new Key(new BigInteger(exponent), new BigInteger(productOfPrimes));
    }
}
