@Test
public void testMethodFinder() throws Exception {

    Method m0 = MethodFinder.findMethod(this.getClass(), "setUp", new Class<?>[0]);
    assertNotNull(m0);

    // this is okay, because method is declared in the type referenced
    Method m = MethodFinder.findMethod(Multimap.class, "put", new Class<?>[] { Object.class, Object.class });
    assertNotNull(m);

    try {
        // this fails, apparently because method is not declared in this subclass (is inherited from parent class)
        Method m2 = MethodFinder.findMethod(HashMultimap.class, "put", new Class<?>[] { Object.class, Object.class });
        assertNotNull(m2);
    } catch (Exception e) {
        System.out.println("got exception. e=" + e);
    }
}