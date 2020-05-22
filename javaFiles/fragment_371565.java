String url="<your url>";
String fileName="<path of file to be uploaded>";
HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost(url);
FileBody fileContent= new FileBody(new File(fileName));
StringBody comment = new StringBody("Filename: " + fileName);
MultipartEntity reqEntity = new MultipartEntity();
reqEntity.addPart("file", fileContent);
httppost.setEntity(reqEntity);

HttpResponse response = httpclient.execute(httppost);
HttpEntity resEntity = response.getEntity();