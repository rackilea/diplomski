public abstract class BaseCall<T> implements Callable<T> {

    public abstract T innerCall();

    protected Structure getProxy() {
       return SomeStructure;
    }
}
public abstract class RunVcTask<T> extends BaseCall<T> {

    private final Credentials credentials;

    public RunVcTask(Credentials credentials) {
        this.credentials = credentials;
    }

    public abstract T actualOp(Structure proxy, Credentials credentials);

    @Override
    public T innerCall() {
        return actualOp(getProxy(), credentials);
    }
}

public class GetXCall extends RunVcTask<Set<String>> {
    public GetXCall(Credentials credentials) {
        super(credentials);
    }

    @Override
    public Set<String> actualOp(Structure proxy, Credentials credentials) {
        return proxy.getXfromVC(credentials);
    }
}
public class GetYCall extends RunVcTask<Set<String>> {
    public GetYCall(Credentials credentials) {
        super(credentials);
    }

    @Override
    public Set<String> actualOp(Structure proxy, Credentials credentials) {
        return proxy.getXfromVC(credentials);
    }
}