@Test
public void testMyMethod() {
    OtherClass obj = new OtherClass();

    //if this fails it might be because of some external code called by 
    //MySingleton.doSomething(), not necessarily the logic inside MyMethod()

    Asserts.assertEqual(1, obj.myMethod());
}