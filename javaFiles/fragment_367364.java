try {
    PropertiesConfiguration props = new PropertiesConfiguration(System.getenv("SIGNATURE_PROPS_FILE"));
    props.setProperty("org.apache.ws.security.crypto.merlin.keystore.password", System.getenv("KEY_STORE_PASSWORD"));
    props.setProperty("org.apache.ws.security.crypto.merlin.keystore.alias", System.getenv("KEY_ALIAS"));
    props.setProperty("org.apache.ws.security.crypto.merlin.keystore.file", System.getenv("KEY_STORE_FILE"));
    props.save();
    logger.debug("** signature.properties updated Successfully!! **");
} catch (ConfigurationException e) {
    logger.error(e.getMessage());
}