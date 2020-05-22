HttpRequestBase request = null;

if (this.httpMethod.equals("POST")) {
   request = new HttpPost(url);
}
else if (this.httpMethod.equals("GET")) {
   request = new HttpGet(url);
}

request.addHeader(...); etc