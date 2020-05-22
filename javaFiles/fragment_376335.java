private static SSLSocketFactory getSocketFactory() 
{
    try 
    {
        SSLContext context = SSLContext.getInstance("TLS");

        // Create a key manager factory for our personal PKCS12 key file
        KeyManagerFactory keyMgrFactory = KeyManagerFactory.getInstance("SunX509");
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        char[] keyStorePassword = pk12Password.toCharArray(); // --> This is the Password for my P12 Client Certificate
        keyStore.load(new FileInputStream(pk12filePath), keyStorePassword); // --> This is the path to my P12 Client Certificate
        keyMgrFactory.init(keyStore, keyStorePassword);

        // Create a trust manager factory for the trust store that contains certificate chains we need to trust
        // our remote server (I have used the default jre/lib/security/cacerts path and password)
        TrustManagerFactory trustStrFactory = TrustManagerFactory.getInstance("SunX509");
        KeyStore trustStore = KeyStore.getInstance("JKS");
        char[] trustStorePassword = jksTrustStorePassword.toCharArray(); // --> This is the Default password for the Java KEystore ("changeit")           
        trustStore.load(new FileInputStream(trustStorePath), trustStorePassword);
        trustStrFactory.init(trustStore);

        // Make our current SSL context use our customized factories
        context.init(keyMgrFactory.getKeyManagers(), 
                trustStrFactory.getTrustManagers(), null);

        return context.getSocketFactory();
    } 
    catch (Exception e) 
    {
        System.err.println("Failed to create a server socket factory...");
        e.printStackTrace();
        return null;
    }
}