Path keystore = Files.createTempFile(null, null);
try (InputStream stream = getClass().getResourceAsStream("/cacerts")) {
    Files.copy(stream, keystore, StandardCopyOption.REPLACE_EXISTING);
}

System.setProperty("javax.net.ssl.trustStore", keystore.toString());