@Test
public void shouldSetup() throws OgnlException {
    class A {
        private Object b = "foo";
        private Object c = "bar";
        public Object getB() { return b; }
    }
    A a = new A();

    // set DefaultMemberAccess with allowed access into the context
    OgnlContext context = new OgnlContext();
    context.setMemberAccess(new DefaultMemberAccess(true));

    System.out.println( "This'll work..." );
    // use context in getValue method
    Ognl.getValue( "b", context, a );

    System.out.println( "...and this'll work..." );
    // use context in getValue method
    Ognl.getValue( "c", context, a );

    System.out.println( "...and we'll get here." );
}