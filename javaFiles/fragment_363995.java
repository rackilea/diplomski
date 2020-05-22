@Timeout
public void handleTimer(final Timer timer) throws IOException, NamingException {
    Context initialContext = new InitialContext();
    mailProperties = (Properties)initialContext.lookup("properties/mailconfig");
    log.info(new Date().toGMTString() + " Programmatical: " + mailProperties.getProperty("to"));        
}