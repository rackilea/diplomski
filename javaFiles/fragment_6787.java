private RequestSpecification getRequestSpec(ContentType requestbodytype, ContentType responsetype, boolean urlEncodingEnabled) {
    writer = new StringWriter();
    captor = new PrintStream(new WriterOutputStream(writer), true);
    return  RestAssured.given().config(RestAssured.config().logConfig(new LogConfig(captor, true))).urlEncodingEnabled(urlEncodingEnabled).log().everything().contentType(requestbodytype).accept(responsetype);
}

protected Response get(String resourceURI, ContentType requestbodytype, ContentType responsetype, boolean urlEncodingEnabled) {
    Response rs = null;
    rs = getRequestSpec(requestbodytype, responsetype, urlEncodingEnabled).when().get(resourceURI);
    Reporter.log("---- Request ----");
    Reporter.log(writer.toString());
    Reporter.log("---- Response ----");
    Reporter.log(rs.asString());
    return rs;
}