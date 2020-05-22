Form form = new Form();
form.param("id", "45");
form.param("summary", "Summary for id 45");
Response response = client.target(url).request().post(Entity.form(form));
String html = response.readEntity(String.class);
System.out.println(html);