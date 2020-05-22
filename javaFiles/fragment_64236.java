public interface Fetcher<T extends Fetchable> {
    T fetch(Endpoint<T> endpoint);
}

public class FetcherImpl implements Fetcher<FetchableImpl> {
    public FetchableImpl fetch(Endpoint<FetchableImpl> endpoint) {
        return null;
    }
}