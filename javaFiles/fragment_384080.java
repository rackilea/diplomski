PostMethod post = new PostMethod("http://localhost:3000/projects");
NameValuePair[] data = {
  new NameValuePair("project[name]", "from java"),
  new NameValuePair("project[life_cycle_id]", "5")
};
post.setRequestBody(data);
// execute method and handle any error responses.

new HttpClient().executeMethod(post);