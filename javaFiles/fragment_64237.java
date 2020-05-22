public interface Fetcher {
    <T extends Fetchable> T fetch(Endpoint<T> endpoint);
}

public class FetcherImpl implements Fetcher {
    public <T extends Fetchable> T fetch(Endpoint<T> endpoint) {
        return null;
    }
}