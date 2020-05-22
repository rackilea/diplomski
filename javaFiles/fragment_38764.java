private static final HttpRequest<String.class> HTTP_REQUEST = 
      HttpRequestBuilder.createPost(YARDI_URL, String.class)
           .responseDeserializer(ResponseDeserializer.ignorableDeserializer())
           .contentTypeOfBody(ContentType.TEXT_XML)
           .connectTimeout(someIntValue)
           .socketTimeOut(someIntValue)
           .connectionRequestTimeout(someIntValue).
           .build();

void testRequest() {
   ResponseHadler<String> yardiHandler = HTTP_REQUEST.executeWithBody(yourXml);

   int statusCode = yardiHandler.getStatusCode();
   String content = yardiHandler.get(); //returns response body as String in this case
}