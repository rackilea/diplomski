public class StackOverflow59960713 {
    public interface I {
        String methodA();
    }

    public static class S implements I {
        private static S INSTANCE = new S();

        public static I getInstance() {
            return INSTANCE;
        }

        public String methodA() {
            return methodB();
        }

        public String methodB() {
            return "abc";
        }

    }

    @Test
    public void testMethodA() {
        S so = (S) S.getInstance();  <== getInstance() returns I not S
        S spy = Mockito.spy(so);
        Mockito.doReturn("123").when(spy).methodB();

        String exp_value = "123";
        assertEquals(exp_value, spy.methodA());  <=== methodA() not methodA
    }
}