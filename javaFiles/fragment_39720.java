public class ClassToTestTest{
    @Test
    public void test(){
        // Given
        OtherObject mockOtherObject = mock(OtherObject.class);
        when(mockOtherObject.methodX()).thenReturn("methodXResult");
        OtherObjectFactory otherObjectFactory = mock(OtherObjectFactory.class);
        when(otherObjectFactory.newInstance()).thenReturn(mockOtherObject);
        ClassToTest classToTest = new ClassToTest(factory);

        // When
        classToTest.methodToTest(input);

        // Then
        // ...
    }
}