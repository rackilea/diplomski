public class Foo {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("path/to/applicationContext.xml");
        //use the context as you wish...
    }
}