package br.com.villela.rsacoreapi.key;

import java.math.BigInteger;

public class KeyPair {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public KeyPair(BigInteger publicKeyExponent, BigInteger privateKeyExponent, BigInteger productsPrimesOfKeys) {
        this.publicKey = new PublicKey(publicKeyExponent, productsPrimesOfKeys);
        this.privateKey = new PrivateKey(privateKeyExponent, productsPrimesOfKeys);
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
