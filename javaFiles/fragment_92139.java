@GET
@Consumes(MediaType.APPLICATION_JSON)
public Response doWork(Person person) {
   // do work
   return Response.ok().build();
}