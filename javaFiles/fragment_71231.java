private void setParameters(SSLSocket socket, String host)
        throws MalformedURLException {
    SSLParameters sslParameters = new SSLParameters();
    List<SNIServerName> sniHostNames = new ArrayList<SNIServerName>(1);
    sniHostNames.add(new SNIHostName(host));
    sslParameters.setServerNames(sniHostNames);
    socket.setSSLParameters(sslParameters);
}