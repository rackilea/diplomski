public abstract class MyClass<T extends Object> {

    private Class<T> klass;

    public MyClass(Class<T> klass) {
        this.klass = klass;
    }

    protected T createNewFromData(Reader reader){
        GSON.fromJSON(reader,klass); 
    }
}