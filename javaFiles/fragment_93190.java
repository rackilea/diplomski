private static AsyncHttpClient client = new AsyncHttpClient();
RequestParams params = new RequestParams();
params.put("param1", "Test"); 
client.post(Url, params, responseHandler);
JSONObject jsonParams = new JSONObject();
jsonParams.put("param1", "Test");
StringEntity entity = new StringEntity(jsonParams.toString());
client.post(context, Url, entity, "application/json",responseHandler);