@GET
@Path("/get")
public Response get (@Context HttpHeaders headers) {
    // Get the value from header, where "header-name" is the key name of the header.
    String value = headers.getRequestHeader("header-name").get(0);
    // Decode the value using MIME decoder.
    try {
        value = javax.mail.internet.MimeUtility.decodeText(value);
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
    System.out.println("Decoded value from header: " + value);
    return Response.ok().build();
}