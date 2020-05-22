@Test
public void testHelloWorld(@Mocked final NeedToBeMockedClass mockInstance){

    new NonStrictExpectations() {
        {
            mockInstance.someMethod(anyInt, anyInt);
            result = true;
        }
    };

    ClassToBeTested classToBeTested = new ClassToBeTested("", true);
    String result = classToBeTested.helloWorld("", "");

    //Assertions, verifications, etc.
}