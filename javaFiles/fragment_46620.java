@Service(FooRequestImpl.class)
public interface FooRequest extends RequestContext {
   Request<List<FooProxy>> findSmt();
}

...

public class FooRequestImpl
{
    List<FooDAO> findSmt()  //note that we dropped the Request and changed the Proxy to the DAO
    {
        return getFoos();
    }
}