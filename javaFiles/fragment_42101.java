.doTry()
  .to("your_http_endpoint")
.doCatch(HttpOperationFailedException.class)
  .choice()
  .when(header(HTTP_RESPONSE_CODE).isEqualTo("500"))
    .to("do your retry or whatever you want to do")
  .otherwise()
    .to("somewhere_else when its not 500")
.end();