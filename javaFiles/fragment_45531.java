private void uploadToServer(String filePath) {
 Retrofit retrofit = NetworkClient.getRetrofitClient(this);
 UploadAPIs uploadAPIs = retrofit.create(UploadAPIs.class);
 //Create a file object using file path
 File file = new File(filePath);
 // Create a request body with file and image media type
 RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
 // Create MultipartBody.Part using file request-body,file name and part name 
 MultipartBody.Part part = MultipartBody.Part.createFormData("upload", file.getName(), fileReqBody);
 //Create request body with text description and text media type
 RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "image-type");
 // 
 Call call = uploadAPIs.uploadImage(part, description);
 call.enqueue(new Callback() {
     @Override
     public void onResponse(Call call, Response response) {
     }
     @Override
     public void onFailure(Call call, Throwable t) {
     }
 });