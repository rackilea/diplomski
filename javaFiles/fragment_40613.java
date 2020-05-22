@PrepareForTest({ ClassA.class, ClassB.class })
public class App extends PowerMockTestCase {
    @Test
    public void shoudlReturn666() throws Exception {
        ClassB mockB = PowerMockito.mock(ClassB.class);
        PowerMockito.when(mockB.get15()).thenReturn(666);
        PowerMockito.whenNew(ClassB.class).withNoArguments().thenReturn(mockB);
        Assert.assertTrue(new ClassA().callB() == 666);
    }
}