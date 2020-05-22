mockObject.someMethod(eq(param1), eq(param2));
expectLastCall().andAnswer(new IAnswer() {
    public Object answer() {
        //supply your mock implementation here...
        SomeClass arg1 = (SomeClass) getCurrentArguments()[0];
        AnotherClass arg2 = (AnotherClass) getCurrentArguments()[1];
        arg1.doSomething(blah);
        //return the value to be returned by the method (null for void)
        return null;
    }
});