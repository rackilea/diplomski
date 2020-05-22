public class ClassThatDoesStuffTest{
    @Mock private TimeHelper mockTime;
    @Mock private ThingConnector mockConnector;
    private ClassThatDoesStuff toTest;

    @Test
    public void doesSomething(){
        // Arrange
        initMocks(this);
        when(mockTime.currentTimeMillis()).thenReturn(1000L, 2000L, 5000L);
        toTest = new ClassThatDoesStuff(mockConnector, mockTime);

        // Act
        toTest.doSomething();

        // Assert
        // ... ???
    }
}