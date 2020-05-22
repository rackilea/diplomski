public interface Example {
    public void method();
}

public abstract class AbstractExample implements Example {

    @Override
    public void method() {
        common();
        implMethod();
    }

    private void common() {
        // common implementation
    }

    protected abstract void implMethod();
}

public class ExampleClientImpl extends AbstractExample {

    @Override
    protected void implMethod() {
        // client implementation
    }
}

public class ExampleServerImpl extends AbstractExample {

    @Override
    protected void implMethod() {
        // server implementation
    }
}