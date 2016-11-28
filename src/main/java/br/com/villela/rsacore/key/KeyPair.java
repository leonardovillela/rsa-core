package br.com.villela.rsacore.key;

import java.math.BigInteger;

public class KeyPair {

    private Key publicKey;
    private Key privateKey;

    public KeyPair(BigInteger publicKeyExponent, BigInteger privateKeyExponent, BigInteger productsPrimesOfKeys) {
        this.publicKey = new Key(publicKeyExponent, productsPrimesOfKeys);
        this.privateKey = new Key(privateKeyExponent, productsPrimesOfKeys);
    }

    public KeyPair(Key publicKey, Key privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public Key getPublicKey() {
        return publicKey;
    }

    public Key getPrivateKey() {
        return privateKey;
    }
}
