import com.w.automation.rtsimulator.headlessclient.data.SearchResult;

Callable<MyClass> callable = new Callable<MyClass>() {
    @Override
    @SuppressWarnings("unchecked")
    public MyClass call() throws Exception {
        return (MyClass) Foo();
    }
};