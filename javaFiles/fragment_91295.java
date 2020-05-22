@POST
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces(MediaType.TEXT_PLAIN)
@Override
public String addNewReport(final Report report, @Context SecurityContext sc) {
   report.setUserName(sC.getUserPrincipal().getName());
   return service.addNewReport(report);
}