Client client = ClientBuilder.newClient();
client.register(MultiPartFeature.class);
WebTarget target = client.target("https://apisomeurl.com");

MultiPart multiPart = new MultiPart();
multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

//Image here
FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("image", new File("/some/img/path/img.png"));
multiPart.bodyPart(fileDataBodyPart);

//MediaType.APPLICATION_JSON_TYPE because I'm expecting a JSON response from the server           
String str = target.queryParam("param1", "1")
                   .queryParam("param2", "2")
                   .queryParam("param3", "3")
                   .request(MediaType.APPLICATION_JSON_TYPE)
                   .post(Entity.entity(multiPart, multiPart.getMediaType()), String.class);