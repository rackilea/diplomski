public DefaultHttpClient getSSLClient(final String user, final String pwd)
        throws KeyManagementException, UnrecoverableKeyException,
        NoSuchAlgorithmException, KeyStoreException {

    ...

    sslClient.getCredentialsProvider().setCredentials(
            new AuthScope("192.168.2.100", port),
            new UsernamePasswordCredentials(user, pwd));

   ...
}