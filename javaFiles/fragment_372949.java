String url = "http://localhost:8088/playground/test.xhtml";
String viewStateName = "javax.faces.ViewState";
String submitButtonValue = "Upload"; // Value of upload submit button.

HttpClient httpClient = new DefaultHttpClient();
HttpContext httpContext = new BasicHttpContext();
httpContext.setAttribute(ClientContext.COOKIE_STORE, new BasicCookieStore());

HttpGet httpGet = new HttpGet(url);
HttpResponse getResponse = httpClient.execute(httpGet, httpContext);
Document document = Jsoup.parse(EntityUtils.toString(getResponse.getEntity()));
String viewStateValue = document.select("input[type=hidden][name=" + viewStateName + "]").val();
String uploadFieldName = document.select("input[type=file]").attr("name");
String submitButtonName = document.select("input[type=submit][value=" + submitButtonValue + "]").attr("name");

File file = new File("/path/to/file/you/want/to/upload.ext");
InputStream fileContent = new FileInputStream(file);
String fileContentType = "application/octet-stream"; // Or whatever specific.
String fileName = file.getName();

HttpPost httpPost = new HttpPost(url);
MultipartEntity entity = new MultipartEntity();
entity.addPart(uploadFieldName, new InputStreamBody(fileContent, fileContentType, fileName));
entity.addPart(viewStateName, new StringBody(viewStateValue));
entity.addPart(submitButtonName, new StringBody(submitButtonValue));
httpPost.setEntity(entity);
HttpResponse postResponse = httpClient.execute(httpPost, httpContext);
// ...