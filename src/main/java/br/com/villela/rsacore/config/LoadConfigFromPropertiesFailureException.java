package br.com.villela.rsacore.config;

public class LoadConfigFromPropertiesFailureException extends RuntimeException {

    public LoadConfigFromPropertiesFailureException() {
        super("Nâo foi possivel ler o arquivo de configuração default das chaves.");
    }
}
