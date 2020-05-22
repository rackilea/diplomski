public Greeter(@PathParam("name") String name, @Context Request request) {
    if ("Vader".equals(name)) {
        Error error = new Error();
        error.message = "Illegal name";
        List<Variant> variants = Variant.mediaTypes(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_XML_TYPE).add().build();
        Variant variant = request.selectVariant(variants);
        Response errorResponse = Response.status(Status.BAD_REQUEST).entity(error).variant(variant).build();
        throw new WebApplicationException(errorResponse);
    } else {
        this.name = name;
    }
}