String bodyAsString = ""; //Provide Input SOAP Message
CredentialsProvider credsProvider = new BasicCredentialsProvider();
credsProvider.setCredentials(AuthScope.ANY,
new NTCredentials("UserName", "Password", "Host", "Domain"));
HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(credsProvider).build();
HttpPost post = new HttpPost("URL"); //Provide Request URL
try 
{
   StringEntity input = new StringEntity(bodyAsString);
   input.setContentType("text/xml; charset=utf-8");
   post.setEntity(input);
   post.setHeader("Content-type", "text/xml; charset=utf-8");
   post.setHeader("SOAPAction", ""); //Provide Soap action

   org.apache.http.HttpResponse response = client.execute(post);
   HttpEntity responseEntity = response.getEntity();
   if (responseEntity != null) 
   {
      return EntityUtils.toString(responseEntity);
   }
}