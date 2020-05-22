// Given
String usernamme = usernames[0];
Resource testImageResource = context.getResource("classpath:images/test_image.jpg");
File imageFile = testImageResource.getFile();
RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imageFile);
MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", imageFile.getName(), requestFile);

// When
Response<Void> response = testApi.uploadProfilePhoto(usernamme, filePart).execute();