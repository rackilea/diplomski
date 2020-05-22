@Provider
public class MyRcProvider implements ContextResolver<MyRc>{
    @Context ServletContext sc; 
    @Override
    public MyRc getContext(Class<?> arg0) {

        return (MyRc)sc.getAttribute("myRc");
    }

}