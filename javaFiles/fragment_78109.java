public interface MyInterface<T extends MyGenericObject> {
    void read(long id, Callback<T> callback);
    void readAll(Callback<Collection<T>> callback);
}

public interface Callback<T> {}
public class MyGenericObject {}
public class SomeObject extends MyGenericObject {}

public class MyClass implements MyInterface<SomeObject> {
    @Override public void read(long id, Callback<SomeObject> callback) {}
    @Override public void readAll(Callback<Collection<SomeObject>> callback) {}
}