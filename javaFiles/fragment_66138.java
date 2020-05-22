public class TestProxy {
    public static void main(String [] args) {
       Person2 p = new Person2("myName");
       InvocationHandler invocationHandler = new MyHandler(p);
       IPerson obj = (IPerson) Proxy.newProxyInstance(
             p.getClass().getClassLoader(),
             p.getClass().getInterfaces(),
             invocationHandler);
       obj.say();
    }
}