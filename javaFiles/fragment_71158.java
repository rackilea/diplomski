@Test
public void test() throws Exception {

    MyLoader customLoader1 = new MyLoader();
    MyLoader customLoader2 = new MyLoader();

    Class<?> c1 = customLoader1.loadClass(SPECIAL_CLASS_NAME);
    Class<?> c2 = customLoader2.loadClass(SPECIAL_CLASS_NAME);

    LoadedClass o1 = (LoadedClass) c1.newInstance();
    LoadedClass o2 = (LoadedClass) c2.newInstance();

    o1.setStaticPart(100d);
    o2.setStaticPart(1d);

    assertEquals(100d, o1.getStaticPart());
    assertEquals(1d, o2.getStaticPart());
}