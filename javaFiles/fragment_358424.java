@POST
@Path("/{courseId}/subjects/{"subjectId"}/description")
public Message get(@PathParam("courseId") String courseId, 
                   @PathParam("subjectId") String subjectId) {
  // .... 
}