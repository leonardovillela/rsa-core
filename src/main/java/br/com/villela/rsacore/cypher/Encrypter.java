package br.com.villela.rsacore.cypher;

import br.com.villela.rsacore.key.Key;

import java.math.BigInteger;

public class Encrypter {

    public static String encrypt(Key publicKey, String text) {
        byte[] serializedText = text.getBytes();
        BigInteger exponent = publicKey.getExponent();
        BigInteger productPrimesOfKeys = publicKey.getProductPrimesOfKeys();

        return new BigInteger(serializedText).modPow(exponent, productPrimesOfKeys).toString();
    }
}
