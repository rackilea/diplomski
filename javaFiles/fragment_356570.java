void doGetRequest(String url) throws IOException{
    Request request = new Request.Builder()
            .url(url)
            .build();

    client.newCall(request)
            .enqueue(new Callback() {
                @Override
                public void onFailure(final Call call, IOException e) {
                    // Error

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // For the example, you can show an error dialog or a toast
                            // on the main UI thread
                        }
                    });
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    String res = response.body().string();

                    // Do something with the response
                }
            });
}