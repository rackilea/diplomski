public class Main {
    public static void main(String[] args) throws Exception {
       ApplicationContext ctx = new ClassPathXmlApplicationContext(
    "context.xml");
    Foo foo = (Foo) ctx.getBean("fooBean");
    foo.doSomethingCool();