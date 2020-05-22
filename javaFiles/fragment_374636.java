@GET
@Path("/id/{id}")
@Produces(MediaType.APPLICATION_JSON)
public double findBonusById(@PathParam("id") long id) {
return employeeService.findBonusById(id);
}