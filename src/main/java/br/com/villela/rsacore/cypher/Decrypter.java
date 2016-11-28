package br.com.villela.rsacore.cypher;

import br.com.villela.rsacore.key.Key;

import java.math.BigInteger;

public class Decrypter {

    public static String decrypt(Key privateKey, String text) {
        BigInteger decryptedResult = new BigInteger(text).modPow(privateKey.getExponent(), privateKey.getProductPrimesOfKeys());
        return new String(decryptedResult.toByteArray());
    }
}
