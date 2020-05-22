@Path("myService")
public class MyResource {
    @GET
    public void doSomething() {
        MyBusinessLogic bean = ... // get it from IoC, new, whatever
        bean.doSomething();
    }
}