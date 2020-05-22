private static String keystoreType;

@Value("${client.keystore.type}")
public void setKeystoreType(String keystoreType) {
    SendMessageController.keystoreType = keystoreType;
}