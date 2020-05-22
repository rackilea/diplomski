client.newCall(request).enqueue(new Callback() {
    @Override 
    public void onFailure(Call call, IOException e) {
        //something went wrong
        Log.e(YOUR_TAG, e);
    }
    @Override 
    public void onResponse(Call call, Response response) throws    IOException {
        if (!response.isSuccessful()) {
            throw new IOException("Response not sueccessful   " + response);
        }
        //success do whatever you want. for example -->
        Log.d(YOUR_TAG, response.body().string());
    }
}