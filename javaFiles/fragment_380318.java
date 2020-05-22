Form form = new Form();
form.add("foo", "bar");
form.add("abc", "123");

Request request = new Request(Method.POST, "http://host/path/to/resource");

request.setEntity(form.getWebRepresentation());

request.setReferrerRef("http://host/path/to/referrer");

Response response = client.handle(request);