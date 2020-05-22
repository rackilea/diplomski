public abstract class Target<L extends Load> {
    public abstract void fire(L load);
}

public class HttpTarget extends Target<HttpLoad> {
    @Override
    public void fire(HttpLoad load) {
        ...
    }
}

public interface TestSuite<L extends Load> { // or class
    L getLoad();
    Target<L> getTarget();
}

public class HttpTestSuite implements TestSuite<HttpLoad> {
    @Override
    public HttpLoad getLoad() {
        ...
    }

    @Override
    public Target<HttpLoad> getTarget() {
        return new HttpTarget();
    }
}