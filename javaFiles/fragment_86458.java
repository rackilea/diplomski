public class HelloWorldResource {

    private SimpleBean simpleBean;

    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }

    @GET @Path("/Hello") @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "{\"Hello\": \"" + this.simpleBean.sayHello() + "\"}";
    }
}