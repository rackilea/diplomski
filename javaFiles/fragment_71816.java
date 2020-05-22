final Resource.Builder subResourceBuilder = resourceBuilder.addChildResource("{id}");

subResourceBuilder.addMethod("GET")
    .produces(MediaType.APPLICATION_JSON_TYPE)
    .handledBy(new Inflector<ContainerRequestContext, Response>() {

    @Override
    public Response apply(ContainerRequestContext rctx) {
         // Get to the path parameter                    
         MultivaluedMap<String, String> pparams = rctx.getUriInfo().getPathParameters();
         List<String> idValues = pparams.get("id");
         // Create response here
    }
});