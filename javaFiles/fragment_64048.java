try{
HttpClient client = new DefaultHttpClient();
HttpPost request = new HttpPost(
"http://www.snee.com/xml/crud/posttest.cgi");

List<NameValuePair> postParameters = new ArrayList<NameValuePair>();

postParameters.add(new BasicNameValuePair("fname", "First name"));
postParameters.add(new BasicNameValuePair("lname", "Last name"));

UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
postParameters);

request.setEntity(formEntity);

HttpResponse response = client.execute(request);

in = new BufferedReader(new InputStreamReader(response.getEntity()
.getContent()));

StringBuffer sb = new StringBuffer("");
String line = "";
String NL = System.getProperty("line.separator");
while ((line = in.readLine()) != null) {
sb.append(line + NL);
}
in.close();}catch(Exception ex){}