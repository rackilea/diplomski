(...)
String url = "http://<XXXX>.appspot.com/api/1/Employee/list/p1/50";
HttpClient client = new HttpClient();
GetMethod get = new GetMethod(url);
client.executeMethod(get);
System.out.println(new String(get.getResponseBody()));
get.releaseConnection();

url = "http://<XXXX>.appspot.com/api/1/Employee/submit";
PostMethod post = new PostMethod(url);
post.addParameter("id", "10");
client.executeMethod(post);
System.out.println(new String(post.getResponseBody()));
post.releaseConnection();
(...)