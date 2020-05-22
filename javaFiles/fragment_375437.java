KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());

    // Trust own CA and all self-signed certs
    SSLContext sslcontext = SSLContexts.custom()
            .loadTrustMaterial(new File("//your jks file path "), "//key password here",
                    new TrustSelfSignedStrategy())
            .build();
    // Allow TLSv1 protocol only
    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
            sslcontext,
            new String[] { "TLSv1" },
            null,
            SSLConnectionSocketFactory.getDefaultHostnameVerifier());
    CloseableHttpClient httpclient = HttpClients.custom()
            .setSSLSocketFactory(sslsf)
            .build();
    try {


     File req_xml = new File("// your request xml file path");


   HttpPost post = new HttpPost("//https client url");
   post.setEntity(new InputStreamEntity(new FileInputStream(req_xml), req_xml.length()));
   post.setHeader("Content-type", "text/xml; charset=UTF-8");

        System.out.println("Executing request " + post.getRequestLine());

        CloseableHttpResponse response = httpclient.execute(post);
        try {
            HttpEntity entity = response.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            EntityUtils.consume(entity);
            System.out.println(response.getEntity());
        } finally {
            response.close();
        }
    } finally {
        httpclient.close();
    }