// T has become SomeObject = put everywhere SomeObject instead of T
public class MyClass implements MyInterface<SomeObject> { 
    @Override
    public void read(long id, Callback<SomeObject> callback) {
        ...
    }

    @Override
    public void readAll(Callback<Collection<SomeObject>> callback) {
        ...
    }
}