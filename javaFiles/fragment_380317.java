Client client = new Client(Protocol.HTTP);

Form form = new Form();
form.add("foo", "bar");
form.add("abc", "123");

Response response = client.post("http://host/path/to/resource", form.getWebRepresentation())

if (response.getStatus().isError()) {
    // deal with the error
    return;
}

if (response.isEntityAvailable()) {
    System.out.println(response.getEntity().getText());
}