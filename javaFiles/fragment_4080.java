public class ATest {

    A a=new A();

    @Test
    public void test1() {
        B b=new B();
        C c=new C();
        a.setB(b);
        a.setC(c);

        a.method();
    }
}