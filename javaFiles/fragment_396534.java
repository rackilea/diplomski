@Test
public void TestMyMethod() {
    OtherClass obj = new OtherClass(new MockNonSingleton());

    //now our mock object can fake the database, filesystem etc. calls to isolate the testing to just the logic in myMethod()

    Asserts.assertEqual(1, obj.myMethod());
}