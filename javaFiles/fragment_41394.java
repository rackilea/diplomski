public class RunVcTask<T> extends BaseCall<T> {
    interface ActualTask<T> {
        T actualOp(Structure proxy, Credentials credentials);
    }
    enum BuiltIn implements ActualTask<Set<String>> {
        GetX {
            public Set<String> actualOp(Structure proxy, Credentials credentials) {
                return proxy.getXfromVC(credentials);
            }
        },
        GetY {
            public Set<String> actualOp(Structure proxy, Credentials credentials) {
                return proxy.getYfromVC(credentials);
            }
        },
    }

    private final Credentials credentials;
    private final ActualTask<T> delegate;

    public RunVcTask(Credentials credentials, ActualTask<T> task) {
        this.credentials = credentials;
        this.delegate = task;
    }

    @Override
    public T innerCall() {
        return delegate.actualOp(getProxy(), credentials);
    }
}