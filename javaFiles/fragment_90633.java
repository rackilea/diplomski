WebSocketOrderClient webSocketOrderClient = new WebSocketOrderClient(uri, new Draft_17(), cmap, TIMEOUT);
SSLContext sslContext = null;
sslContext = SSLContext.getInstance( "TLS" );
sslContext.init( null, null, null ); // will use java's default key and trust store which is sufficient unless you deal with self-signed certificates

webSocketOrderClient.setWebSocketFactory(new DefaultSSLWebSocketClientFactory(sslContext));
webSocketOrderClient.connectBlocking();