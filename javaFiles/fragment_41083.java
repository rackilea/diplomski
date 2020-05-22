@POST
@Path("/addEmp")
@Produces("text/plain")
public String doOrder(@BeanParam final @Valid Employee emp) {

    // Some implementation here
}