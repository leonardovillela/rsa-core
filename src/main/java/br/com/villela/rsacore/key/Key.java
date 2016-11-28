package br.com.villela.rsacore.key;

import java.math.BigInteger;

public class Key {

    private BigInteger exponent;
    private BigInteger productPrimesOfKeys;

    public Key(BigInteger exponent, BigInteger productPrimesOfKeys) {
        this.exponent = exponent;
        this.productPrimesOfKeys = productPrimesOfKeys;
    }

    public BigInteger getExponent() {
        return exponent;
    }

    public BigInteger getProductPrimesOfKeys() {
        return productPrimesOfKeys;
    }

    @Override
    public String toString() {
        return exponent.toString() + "|" + productPrimesOfKeys.toString();
    }
}
