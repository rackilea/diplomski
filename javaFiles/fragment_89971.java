HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();

Gson gson = new Gson();
        String gsonString = gson.toJson(currentCustomer);
        Log.v("gson", gsonString);

        StringEntity se = new StringEntity(gson.toJson(currentCustomer),
                "UTF-8");
HttpPost httpRequest = new HttpPost(methodURL);
        httpRequest.setHeader("customerRegisrationData", gsonString);
        httpRequest.setEntity(se);

        HttpResponse response = httpClient.execute(httpRequest,
                localContext);