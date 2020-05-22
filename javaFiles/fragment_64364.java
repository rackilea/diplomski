HttpClient httpclient = new DefaultHttpClient();

HttpPost httpPost = new HttpPost("http://project.chippy.ch/upload.php");

String json = "";

json = auth.toString();

StringEntity se = new StringEntity(json);
se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
httpPost.setEntity(se);

httpPost.setHeader("User-Agent", "WalkingTourCreator/1.0");
httpPost.setHeader("Accept", "application/json");
httpPost.setHeader("Content-type", "application/json");