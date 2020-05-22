@org.junit.Test
public void test() throws Exception {
    PrivateConstructorInstantiationDemo instance1 = Whitebox.invokeConstructor(PrivateConstructorInstantiationDemo.class, new Class<?>[]{Integer.TYPE}, new Object[]{43});
    PrivateConstructorInstantiationDemo instance2 = Whitebox.invokeConstructor(PrivateConstructorInstantiationDemo.class, new Class<?>[]{Integer.class}, new Object[]{43});
    System.out.println();
}