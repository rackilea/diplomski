private int uploadedImageCount;

...

public void sendAll() {
    uploadedImageCount = 0;
    OkHttpClient client = new OkHttpClient();
    client.dispatcher().setMaxRequestsPerHost(50);
    MediaType MEDIA_TYPE = MediaType.parse("image/png");

    for (int i = 0; i < images.size(); i++) {
        File sourceFile = new File(images.get(i).getImageURI());

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image", sourceFile.getName(), RequestBody.create(MEDIA_TYPE, sourceFile))
                .addFormDataPart("name", images.get(i).getJobID())
                .build();

        Request request = new Request.Builder()
                .url("xxxxxxxxxxx")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onImageUploadFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    onImageUploaded();
                } else {
                    onImageUploadFailed();
                }
            }
        });
    }

    if (signatures.size() > 0) {
        File sourceFile = new File(Uri.parse(signatures.get(0).getImageURI()).toString());
        String newJobID = signatures.get(0).getJobID().concat("-signature");

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image", sourceFile.getName(), RequestBody.create(MEDIA_TYPE, sourceFile))
                .addFormDataPart("name", newJobID)
                .build();

        Request request = new Request.Builder()
                .url("XXXXXXXXXXX")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}

public void onImageUploaded() {
    uploadedImageCount++;
    if (uploadedImageCount == images.size()) {
        runFinalRequest();
    }
}

public void onImageUploadFailed() {
    // Handle failure case. You may detect failed image and try to resend
}