@Path("/todo/{varX}/{varY}")
@Produces({"application/xml", "application/json"})
public Todo whatEverNameYouLike(@PathParam("varX") String varX,
    @PathParam("varY") String varY) {
        Todo todo = new Todo();
        todo.setSummary(varX);
        todo.setDescription(varY);
        return todo;
}