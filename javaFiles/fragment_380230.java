public class D {
    public static void main(String[] args) {
        C c = Mockito.mock(C.class);
        G g = Mockito.mock(G.class);
        B b = new B();
        A a = new A();
        F f = new F();
        doReturn(g).when(c).getResult(eq(a), eq(f));
        c.getResult(a, f); 
        verify(c, times(1)).getResult(eq(a), eq(f));

    }
}