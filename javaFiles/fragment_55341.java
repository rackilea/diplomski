public MyUnitTest {
    private static final MyClass2 class2 = mock(MyClass2.class);

    @Begin
    public void setupTests() {
        when(class2.get(1000)).thenReturn(new User(1000, "John"));
        when(class2.validateObject(anyObj()).thenReturn(true);
    }

    @Test
    public void testFunctionCall() {
        String out = myClass.functionCall();
        assertThat(out).isEqualTo("Output");
    }
}