HurlStack hurlStack = new HurlStack() {
        @Override
        protected HttpURLConnection createConnection(java.net.URL url)
                throws IOException {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) super
                    .createConnection(url);
            try {
                httpsURLConnection
                        .setSSLSocketFactory(getSSLSocketFactory(context));
                // httpsURLConnection.setHostnameVerifier(getHostnameVerifier());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return httpsURLConnection;
        }
    };