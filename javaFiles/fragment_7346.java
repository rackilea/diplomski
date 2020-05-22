Client client = ClientBuilder.newClient();
WebTarget target = client.target("https://myschool.com/webapi/rest/student/").path("submitJob");
Form form = new Form();
form.param("student", student);
form.param("score", score);
String responseResult = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);