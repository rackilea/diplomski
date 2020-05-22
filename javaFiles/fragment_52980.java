String protocol = "TLS";
String provider = "myIbmRFC";
SSLContext context = SSLContext.getInstance(protocol, provider);
context.init(....); // read javadoc about this
SSLParameters enabled = context.getDefaultSSLParameters();
SSLParameters supported = context.getSupportedSSLParameters();
// these two should return RFC names (a mapping between IBM and RFC)
String[] enabledCipherSuites = enabled.getCipherSuites();
String[] supportedCipherSuites = supported.getCipherSuites();