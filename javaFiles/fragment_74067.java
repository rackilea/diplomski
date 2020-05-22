@GET
  @Path("/stop/{id}")
  public void stop(
  @PathParam("id") String id,
  @Context HttpServletRequest request,
  @Context HttpServletResponse response) throws ServletException,
  IOException
  {
    server.stop(id);
    return null;
  }