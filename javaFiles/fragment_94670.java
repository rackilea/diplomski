when(x.callFunction(10)).thenAnswer(new Answer<String>() {
    public String answer(InvocationOnMock invocation)  {
        System.out.println("Mock called---going to return hello");
        return "Hello";
    }
});