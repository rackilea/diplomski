@Path("/foo")
public class FooResource {
    @GET
    @Path("/bar")
    public void bar(@BeanParam MyBean myBean) {
      // Do something
    }
}

public class MyBean {
    private String uaCompatible;

    public MyBean(@HeaderParam("X-UA-Compatible") String uaCompatible) {
        this.uaCompatible = uaCompatible;
    }

    public String getUacompatible() {
        return this.uaCompatible;
    }
}