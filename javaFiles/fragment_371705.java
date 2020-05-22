@Test
public void partiallyMockTestedClass() {
    new NonStrictExpectations(classToTestInstance) {{
        invoke(classToTestInstance, "methodToMock", anyInt);

        result = new Delegate() {
           boolean delegate() {
               boolean nextValue = ...choose next return value somehow...
               return nextValue;
           }
        }
    }};

    classToTestInstance.methodToTest();
    classToTestInstance.methodToTest();
    classToTestInstance.methodToTest();
}