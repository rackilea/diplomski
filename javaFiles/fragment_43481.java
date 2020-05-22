public String getXmlFromUrl(String url) throws Exception {
    return new AsyncTask<String, Void, String>() {
        @Override
        protected String doInBackground(String... params) {
            String xml = null;
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpPost = new HttpGet(params[0]);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                // I printed the response here but I got nothing !
                HttpEntity httpEntity = httpResponse.getEntity();
                xml = EntityUtils.toString(httpEntity);
                Log.i("DEMO", xml);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return xml;
        }
    }.execute(url).get();

}