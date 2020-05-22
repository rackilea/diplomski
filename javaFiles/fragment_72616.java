HttpPost httppost = new HttpPost(url);
MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
entity.addPart("data", new ByteArrayBody(image,"image/jpeg","avatar.jpg"));
httppost.setEntity(entity);
response = httpClient.execute(httppost);
processResponse(response);