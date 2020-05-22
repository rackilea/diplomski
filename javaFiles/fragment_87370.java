public class MyClassServiceImpl extends RemoteServiceServlet implements MyClassService{
    @Override
    public void doSomething() {
        MyBusinessLogic bean = ... // get it from IoC, new, whatever
        bean.doSomething();
    }
}