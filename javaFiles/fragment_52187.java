SslContext sslcontext = GrpcSslContexts.forClient()
    // if server's cert doesn't chain to a standard root
    .trustManager(caFile)
    .keyManager(clientCertFile, keyFile) // client cert
    .build();
channel = NettyChannelBuilder.forAddress(serverHost, serverPort)
    .sslContext(sslContext)
    .build();