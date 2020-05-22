@POST
@Path ("/addData")
@produce(MediaType.Application_Json)
@Consume(MediaType.Application_JSON)
public User addData(User newUser){
  //do something
  return newUser;
}