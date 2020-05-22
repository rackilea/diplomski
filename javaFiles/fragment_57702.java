@Test
public void test() {
    SomethingDoer somethingDoer = mock(SomethingDoer.class);
    MyClass myClass = new MyClass(somethingDoer);
    myClass.myMethod();
    verify(somethingDoer).doSomething(17, 33);
    verify(somethingDoer).doSomething(9, 18);
}