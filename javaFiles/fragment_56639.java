@Test
public void testMethodToBeTested() {
    TestedClass testedClass = Mockito.spy(new TestedClass());
    Mockito.doNothing().when(testedClass).methodToBeSkipped();

    testedClass.methodToBeTested();
    // Assertions etc.
}