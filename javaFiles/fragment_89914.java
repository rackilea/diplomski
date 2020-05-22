WebResource resource = client.resource("http://localhost:8080/rest/samp/create");
String request = "<your_xml>...</your_xml>";
String response = resource.accept(
     MediaType.TEXT_XML).
     header("X-FOO", "BAR"). //this line is not necessary, just an example
     type(MediaType.TEXT_XML).
     post(String.class, request);