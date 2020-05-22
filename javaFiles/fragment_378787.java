String scheme = "https";
Protocol baseHttps = Protocol.getProtocol(scheme);
int defaultPort = baseHttps.getDefaultPort();

ProtocolSocketFactory baseFactory = baseHttps.getSocketFactory();
ProtocolSocketFactory customFactory = new CustomHttpsSocketFactory(baseFactory);

Protocol customHttps = new Protocol(scheme, customFactory, defaultPort);
Protocol.registerProtocol(scheme, customHttps);