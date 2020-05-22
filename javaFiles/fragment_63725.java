httppost = new HttpPost(URL);
MultipartEntity entity = new MultipartEntity();
entity.addPart("title", new StringBody("position.csv", Charset.forName("UTF-8")));
File myFile = new File(Environment.getExternalStorageDirectory(), file);
FileBody fileBody = new FileBody(myFile);
entity.addPart("file", fileBody);
httppost.setEntity(entity);
httppost.getParams().setParameter("project", id);