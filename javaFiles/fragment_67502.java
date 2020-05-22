MyJaxbRequestDataObjectrequest = createMyJaxbRequestDataObject();
    Map<String, String> uriArguments= createUriArguments();
    String url = restBaseUrl + "/myputservice/{usertId}?servicekey={servicekey}";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_XML);
    HttpEntity<MyJaxbRequestDataObject> entity = new HttpEntity<MyJaxbRequestDataObject>(request, headers);
    ResponseEntity<MyJaxbResponseDataObject> responseWrapper = shogunRestTemplate.exchange(url, HttpMethod.PUT, entity, MyJaxbResponseDataObject.class, uriArguments);
    MyJaxbResponseDataObjectresponse = responseWrapper.getBody();