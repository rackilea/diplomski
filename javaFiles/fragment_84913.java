@Path("/resource")
@Singleton
public class JerseySingletonClass {
    //methods ...
}

public class MyApplication extends ResourceConfig {

    /*Register JAX-RS application components.*/
    public MyApplication () {
        register(JerseySingletonClass.class);
    }
}