private void loadData() {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url(URL)
            .build();
    Call call = client.newCall(request);
    call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            // Some error has occurred
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {   
            processData(response.body().string());
        }
    });
}

private void processData(String data) {
    Log.d("DATA", data);
    // To other stuff here given your value data. 
}