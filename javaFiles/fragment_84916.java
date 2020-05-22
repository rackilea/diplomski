String strResponse = "";

    String process_id = "system_name of the process you want to start";

    String url = "Your App Url Here/processes/" + process_id;

    String json = "{"+
        "\"run-stateless\" : \"false\","+
        "\"data\" :"+
        "   { "+
        "       \"variables\" : "+
        "           {   \"Variable name\" : \"Variable value\" } "+
        "   } "+
        "}";

    CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    BufferedReader rd = null;
    CloseableHttpResponse cls = null;
    try {
        HttpPost request = new HttpPost(url);

        // set timeouts as you like
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(60 * 1000).setConnectTimeout(20 * 1000)
                .setConnectionRequestTimeout(20 * 1000).build();

        request.setConfig(config);

        StringEntity params = new StringEntity(json);

        request.addHeader("Accept", "application/json");

        request.addHeader(
                "Authorization",
                "Basic "
                        + com.documentum.xmlconfig.util.Base64
                                .encode("username here" + ":"
                                        + "password here"));

        request.addHeader("Content-Type", "application/vnd.emc.xcp+json");

        request.setEntity(params);

        try {

            cls = httpClient.execute(request);

            HttpEntity entity = cls.getEntity();

            rd = new BufferedReader(new InputStreamReader(
                    entity.getContent()));
            String line = "";
            while (line != null) {
                line = rd.readLine();
                strResponse += line;
            }

            strResponse = strResponse.trim().replace("\n", "");

            String statusline = cls.getStatusLine().toString();
            if (!statusline.contains("200") && !statusline.contains("201")) {

                Log.write("Process is not started");
                // log the strResponse or do something with it

            } else {
                System.out.println("Process started successfully");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    } finally {

        // using commons-io-2.4.jar
        IOUtils.closeQuietly(httpClient);
        IOUtils.closeQuietly(cls);
        IOUtils.closeQuietly(rd);

    }