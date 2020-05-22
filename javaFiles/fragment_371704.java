@Test
public void partiallyMockTestedClass() {
    new NonStrictExpectations(classToTestInstance) {{
        invoke(classToTestInstance, "methodToMock", anyInt);
        returns(false, false, true);
    }};

    classToTestInstance.methodToTest();
    classToTestInstance.methodToTest();
    classToTestInstance.methodToTest();
}