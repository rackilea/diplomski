@POST
@Path("/myMethod")
@Consumes(MediaType.APPLICATION_JSON)
public void myServerMethod(MyPostData data)
{
    System.out.println(data.getContent() + " " + data.getQuestion());
}