public String postImage (String imagePath) {

    result = ""+ System.currentTimeMillis();
    RequestBody requestBody = new MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("fileToUpload", result + ".png",
                    RequestBody.create(MEDIA_TYPE_PNG, new File(imagePath)))
            .build();

    Request request = new Request.Builder()
            .url("http://192.168.0.17/addImage.php")
            .post(requestBody)
            .build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
        }
        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                result = response.body().string();
            }
        }
    });
    return "http://192.168.0.17/uploads/"+result;
}