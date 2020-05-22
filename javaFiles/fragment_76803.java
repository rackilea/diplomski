@POST
@Path("/goes")
@Consumes("application/json")
@Produces("application/json")
public void createTodoAsync3(@Suspended final AsyncResponse asyncResponse, Todo todo) {

    CompletableFuture<Response> future = CompletableFuture.supplyAsync(() -> createTodo3(todo));
    future.thenAccept(resp -> asyncResponse.resume(resp));
}
private Response createTodo3(Todo todo) {
    //all logic goes here
    return Response.accepted().entity(todo).build();
}