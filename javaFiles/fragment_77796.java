@Test(expcted = CustomException.class)
public void testExMethod() {
    @Mock
    private Test test;
    when(test.testEx()).thenThrow(CustomException.class);
    test.testEx("test string");
}