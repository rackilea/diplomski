String credentials = login + ":" + mPassword;
            authString = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            HttpClient httpclient = HTTPUtils.getNewHttpClient(HOST.startsWith(HTTPS_STRING));
            URI newURI = URI.create(HOST);
            HttpGet httpGet =  new HttpGet(newURI);
            httpGet.setHeader("Authorization", authString);

            try {
                HttpResponse response = httpclient.execute(httpGet);
                int code = response.getStatusLine().getStatusCode();
                return code;
...