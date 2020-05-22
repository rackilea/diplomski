KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

    String path1 = ..absolute path of keystore..
    path1 = path1.replaceAll("%20", " ");
    InputStream trustStore1 = new FileInputStream(path1);
    keyStore.load(trustStore1, new String(..keystore password..).toCharArray());
    trustStore1.close();

    KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
    keyManagerFactory.init(keyStore, new String(..keystore password..).toCharArray());

    TrustManagerFactory tmf =  TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(keyStore);
    SSLContext ctx = SSLContext.getInstance("SSL");
    ctx.init(keyManagerFactory.getKeyManagers(), tmf.getTrustManagers(), null);
    HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());