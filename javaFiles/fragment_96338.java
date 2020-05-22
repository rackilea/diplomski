RequestParam params = new RequestParams();
params.put("key1", "value1");
params.put("key2", "value2");

File imgFile = new File(filePath);
try {
      params.put("file",imgFile);
} catch(FileNotFoundException e) {}

AsyncHttpClient image = new AsyncHttpClient();
image.post(uploadURL, params, new AsyncHttpResponseHandler(){});