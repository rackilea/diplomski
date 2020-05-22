@FunctionName("HttpTrigger-Java")
public HttpResponseMessage run(
        @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
        final ExecutionContext context) {
    String contentType = request.getHeaders().get("content-type"); // Get content-type header
    // here the "content-type" must be lower-case
    String body = request.getBody().get(); // Get request body
    InputStream in = new ByteArrayInputStream(body.getBytes()); // Convert body to an input stream
    String boundary = contentType.split(";")[1].split("=")[1]; // Get boundary from content-type header
    int bufSize = 1024;
    MultipartStream multipartStream  = new MultipartStream(in, boundary.getBytes(), bufSize, null); // Using MultipartStream to parse body input stream
    // the code below comes from the SO thread above
    // you can fetch a file content from readBodyData 
    // after the headers Content-Disposition: form-data; name="upfile"; filename="test.txt" \n Content-Type: text/plain
    boolean nextPart = multipartStream.skipPreamble();
    while (nextPart) {
        String header = multipartStream.readHeaders();
        System.out.println("");
        System.out.println("Headers:");
        System.out.println(header);
        System.out.println("Body:");
        multipartStream.readBodyData(System.out);
        System.out.println("");
        nextPart = multipartStream.readBoundary();
    }
    return request.createResponseBuilder(HttpStatus.OK).body("Success").build();
}