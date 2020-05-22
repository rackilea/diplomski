static {
    URL url = null;
    try {
        URL baseUrl;
        baseUrl = com.ibm.eci.soaservice.SOAService.class.getResource(".");
        url = new URL(baseUrl, "file:/C:/local/path/to/wsdl/SOAService.wsdl");
    } catch (MalformedURLException e) {
        logger.warning("Failed to create URL for the wsdl Location: 'file:/C:/local/path/to/wsdl/SOAService.wsdl', retrying as a local file");
        logger.warning(e.getMessage());
    }
    SOASERVICE_WSDL_LOCATION = url;
}