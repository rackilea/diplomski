@GET @Path("kmz")
@Produces("application/vnd.google-earth.kmz")
public InputStream getKmz(@Context UriInfo uriInfo,
        @QueryParam("lat") double lat,
        @QueryParam("lon") double lon,
        @QueryParam("alt") double alt,
        @Context Providers providers,
        @Context HttpHeaders headers)
        throws IOException {

    Viewable v = getKml(lat, lon, alt);
    MessageBodyWriter<Viewable> w = providers.getMessageBodyWriter(Viewable.class, Viewable.class, new Annotation[0], "application/xml");
    OutputStream os = //create the stream you want to write the viewable to (ByteArrayOutputStream?)
    InputStream result = //create the stream you want to return
    try {
        w.writeTo(v, v.getClass(), v.getClass(), new Annotation[0], headers, os);
        // Do something with result; e.g., add to ZIP archive and return
    } catch (IOException e) {
        // handle
    }
    return result;
}