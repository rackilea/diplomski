public class SimpleTest {

    public class A {
    }

    public class B {
        public int getResult(A anObj) {
            throw new RuntimeException("big problem");
        }
    }

    @Test
    public void testEz() throws Exception {

        B b = new B();
        B spy = spy(b);

        doReturn(10).when(spy).getResult(null);

        int r = spy.getResult(null);

        assert (r == 10);

    }

}