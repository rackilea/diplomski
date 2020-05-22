import javax.ws.rs.client.Client;
    import javax.ws.rs.client.ClientBuilder;
    import javax.ws.rs.client.Entity;
    import javax.ws.rs.core.Response;
    import javax.ws.rs.core.MediaType;
    Client client = ClientBuilder.newClient();
    Entity payload = Entity.json("{  'image': 'http://media.kairos.com/kairos- 
 elizabeth.jpg',  'subject_id': 'Elizabeth',  'gallery_name': 'MyGallery'}");
   Response response = client.target("https://api.kairos.com/enroll")
  .request(MediaType.APPLICATION_JSON_TYPE)
  .header("app_id", "4985f625")
  .header("app_key", "aa9e5d2ec3b00306b2d9588c3a25d68e")
  .post(payload);

System.out.println("status: " + response.getStatus());
System.out.println("headers: " + response.getHeaders());
System.out.println("body:" + response.readEntity(String.class));