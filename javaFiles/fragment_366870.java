void getResponse(String getUrl, final Activity activity, final Consumer<String> consumer) throws IOException {

    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url(getUrl)
            .build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            call.cancel();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {

            final String myResponse = response.body().string();

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        JSONObject json = new JSONObject(myResponse);
                        //txtString.setText("First Name: "+json.getJSONObject("data").getString("first_name") + "\nLast Name: " + json.getJSONObject("data").getString("last_name"));
                        //ReturnedString(json.toString());
                        consumer.accept(json.toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    });
}