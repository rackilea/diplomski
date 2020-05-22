OkHttpClient okHttpClient = new OkHttpClient();
Request request = new Request.Builder().url(url).build();
okHttpClient.newCall(request).enqueue(new Callback() {
    @Override
    public void onResponse(Call call, final Response response) throws IOException {  
        try {
            final String responseData = response.body().string();
            JSONObject json = new JSONObject(responseData);

            String flightNumber = json.getString("flight_number");
            // TODO: Load number into a TextView
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
});