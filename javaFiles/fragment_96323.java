public static synchronized void API(String URL, JSONObject uploadata, Context context)
    {
        try {
            URL = URL + "/" + uploadata.get("id") + "?";
            HttpParams httpParameters = new BasicHttpParams();
            int timeoutConnection = 30000;
            HttpConnectionParams.setConnectionTimeout(httpParameters,
                    timeoutConnection);
            int timeoutSocket = 30000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
            uploadata.put("token", NetworkUtilities.Get_token(null, context));
            HttpClient httpClient = new DefaultHttpClient(httpParameters);
            LOG.d("DEYU", "" + 1);
            HttpPut put = new HttpPut(URL);
            LOG.d("DEYU", "" + 2);
            put.addHeader(new BasicHeader("content-type", "application/json"));
            put.setEntity(new StringEntity(uploadata.toString(), HTTP.UTF_8));
            LOG.d("DEYU", "" + 3);
            HttpResponse resp = httpClient.execute(put);
            LOG.d("DEYU", "" + 4);
            String state = String.valueOf(resp.getStatusLine().getStatusCode());
            LOG.d("DEYU", "!" + state);
            if (state.equals("200")) {
                reSetDirty(uploadata.getString("user_id"), context);
            }
        } catch (Exception e) {
            LOG.d("DEYU ", "Put error" + e);
        } finally {
            LOG.d("finally", "finally");
        }
    }