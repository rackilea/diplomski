class B1 {
    String name = "xxx";
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

@Aspect
class A1 {
    @Before("execution(void test.B1.set*(*))")
    public void before(JoinPoint jp) throws Exception {
        String prop = jp.getSignature().getName().substring(3);
        Object target = jp.getTarget();
        Object before = target.getClass().getMethod("get" + prop).invoke(target);
        Object now = jp.getArgs()[0];
        System.out.println(prop + " changed from " + before + " to " + now);
    }
}

public class Test1 {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("test1.xml");
        B1 b1 = ctx.getBean(B1.class);
        b1.setName("yyy");
    }
}