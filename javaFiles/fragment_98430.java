public SSLTunnelSocketFactory(String proxyhost, String proxyport){
      tunnelHost = proxyhost;
      tunnelPort = Integer.parseInt(proxyport);
      dfactory = (SSLSocketFactory)sslContext.getSocketFactory();
 }

 ...

 connection.setSSLSocketFactory( new SSLTunnelSocketFactory( proxyHost, proxyPort ) );
 connection.setDefaultHostnameVerifier( new HostnameVerifier()
 {
    public boolean verify( String arg0, SSLSession arg1 )
    {
        return true;
    }
 }  );