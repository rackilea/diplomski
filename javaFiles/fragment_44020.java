public abstract class MyResource {
    ResponseBuilder response;

    // this gets injected in the ResourceContext.initResource() method
    @Context
    Request request;

    // additional JAX-RS annotated fields you would like to have injected such as
    @PathParam("id")
    private String pathParamId;

    protected String param1;

    // constructor JAX-RS annotated parameters would not get re-initialized  
    public MyResource(@QueryParam("param1") String param1) {
        this.param1 = param1;
        this.request = request;
        this.response = Response.ok();
    }
}