// my-api.jar
public interface MyAPI {
    String doSomething();
}

public interface MyAPIFactory {
    MyAPI getImplementationOfMyAPI();
}