@Inject
ContainerRequest request;

if (request.getMethod().toUpperCase().equals("POST")
     && request.getMediaType().equals(MediaType.APPLICATION_FORM_URLENCODED_TYPE)) {
    request.bufferEntity();
    Form form = request.readEntity(Form.class);
    MultivaluedMap<String, String> params = form.asMap();
}