Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new FormBody.Builder().add("keyword", "android").build();
            Request request = new Request.Builder()
                    .url("http://gankio.herokuapp.com/search")
                    .post(requestBody)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                Log.d("TAG", response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    thread.start();