@GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response getUser(String Id) {
    // Pseudo-code for retrieving user
    User userFromDB = retrieveUserFromDB(user);
    User user = new User();
    user.setUserName(userFromDB.getUserName());
    user.setUserEmail(userFromDB.getUserEmail());
    Response.status(200).entity(user);
  }