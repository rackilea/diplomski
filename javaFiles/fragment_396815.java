public interface common<T extends common<?>> {
    public void commonMethod(T param, ...);
}

public class child implements common<child> {
    public void commonMethod(child param, ...) {
        ...
    }
}