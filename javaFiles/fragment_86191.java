public class MyException extends WebApplicationException {

public MyException(JSONObject jsonObject) {
    super(Response.status(Response.Status.OK)
            .entity(jsonObject)
            .type(MediaType.APPLICATION_JSON)
            .build());
}