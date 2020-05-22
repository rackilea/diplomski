ClaimTask claim = new com.howtodoinjava.model.ClaimTask();
  claim.setTaskId("002481F0-8E9F-11E3-FB97-B80661C15631");
  claim.setTaskId("002481F0-8E9F-11E3-FB97-B80661C15635");

  StringWriter writer = new StringWriter();
  JAXBContext jaxbContext = JAXBContext.newInstance(ClaimTask.class);
  Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
  jaxbMarshaller.marshal(claim, writer);

 DefaultHttpClient httpClient = new DefaultHttpClient();

 // Define a postRequest request
 HttpPost postRequest = new HttpPost(
"http://localhost:8090/BPMService/v1/tasks/claimTaskObj");

 // Set the API media type in http content-type header
 postRequest.addHeader("SAMLart","XXXXXX");
 postRequest.addHeader("otdsticket","YYYYYYYYYYYYY");
 postRequest.addHeader("content-type", "application/xml");

// Set the request post body
StringEntity userEntity = new StringEntity(writer.getBuffer().toString());
postRequest.setEntity(userEntity);

// Send the request; It will immediately return the response in
// HttpResponse object if any
HttpResponse response = httpClient.execute(postRequest);

// verify the valid error code first
int statusCode = response.getStatusLine().getStatusCode();