protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {

  String par = request.getParameter("myParameter");

  String par2 = someStuff();

  JSONObject json = new JSONObject();

  json.put("myParameter", par);
  json.put("otherParameter", par2);

  HttpPost method = new HttpPost(new URI("https://host/service"));
  method.setHeader("Content-Type", "application/json");
  method.setEntity(new StringEntity(json.toString(), ContentType.APPLICATION_JSON));
  HttpParams params=message.getParams();
  HttpConnectionParams.setConnectionTimeout(params, timeout);
  HttpConnectionParams.setSoTimeout(params, timeout);
  HttpClient client = new DefaultHttpClient();
  HttpResponse response = client.execute(method);
  InputStream in = response.getEntity().getContent();

  // Do whatever you want with the server response
  // available in "in" InputStream

  ...
}