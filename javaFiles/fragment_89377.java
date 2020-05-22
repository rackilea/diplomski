File f = new File("/path/fileToUpload.txt");
  PostMethod filePost = new PostMethod("http://host/some_path");
  Part[] parts = {
      new StringPart("param_name", "value"),
      new FilePart(f.getName(), f)
  };
  filePost.setRequestEntity(
      new MultipartRequestEntity(parts, filePost.getParams())
      );
  HttpClient client = new HttpClient();
  int status = client.executeMethod(filePost);