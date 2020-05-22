ResteasyClient client = (ResteasyClient) this.client;
ResteasyWebTarget target = client.target("http://localhost:8080").path("path");
MultipartFormDataOutput mdo = new MultipartFormDataOutput();
mdo.addFormData("firstPart", new ByteArrayInputStream("firstContent".getBytes()), MediaType.TEXT_PLAIN_TYPE);
mdo.addFormData("secondPart", new ByteArrayInputStream("secondContent".getBytes()), MediaType.TEXT_PLAIN_TYPE);
GenericEntity<MultipartFormDataOutput> entity = new GenericEntity<MultipartFormDataOutput>(mdo) { };
Response response = target.request().put(Entity.entity(entity, MediaType.MULTIPART_FORM_DATA_TYPE));
response.close();