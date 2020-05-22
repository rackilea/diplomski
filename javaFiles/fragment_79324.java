InputStreamReader isr = new InputStreamReader (is);
Gson gson = new Gson();
Response lis = new Gson().fromJson(isr, Response.class);
Log.i("Response is  ",""+lis.response.status_code);
Log.i("Message is ",""+lis.response.message);
Log.i("Response_for is ",""+lis.response.response_for);