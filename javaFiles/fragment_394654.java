@GET
@Produces(MediaType.TEXT_PLAIN)
public String hello(
    @Context final RoutingContext routingContext) {

    return "Hello" 
        + routingContext;

}