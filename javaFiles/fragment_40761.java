public class So49013862Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("foo.xml");
        System.out.println(ctx.getBean("foo"));
        ctx.close();
    }

}