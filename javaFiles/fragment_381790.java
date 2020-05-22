ClientResponse response = Client.create()
                                .resource(url)
                                .get(ClientResponse.class);
String contentType = response.getHeaders()
                             .getFirst("Content-Type");
System.out.println(contentType);