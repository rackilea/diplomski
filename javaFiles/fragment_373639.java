@POST
@Path("/users")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public User createUserJson(User user) {
     /* Do something */
     return user;
}

@POST
@Path("/users")
@Consumes({MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_XML})
public User createUserXml(User user) {
     /* Do something */
     return user;
}