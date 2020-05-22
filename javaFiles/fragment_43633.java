@Test
public void test01(){
    MyClass spyMyClass = spy(myClass);
    doReturn(28).when(spyMyClass).method2(anyInt());
    int a = spyMyClass.method1();
    assertTrue("We did it!!!",a==28);
}