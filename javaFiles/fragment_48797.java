@RunWith(PowerMockRunner.class)
// We prepare PartialMockClass for test because it's final or we need to mock private or static methods
@PrepareForTest(PartialMockClass.class)
public class YourTestCase {
@Test
public void privatePartialMockingWithPowerMock() {        
    PartialMockClass classUnderTest = PowerMockito.spy(new PartialMockClass());

    // use PowerMockito to set up your expectation
    PowerMockito.doReturn(value).when(classUnderTest, "methodToMock", "parameter1");

    // execute your test
    classUnderTest.execute();

    // Use PowerMockito.verify() to verify result
    PowerMockito.verifyPrivate(classUnderTest, times(2)).invoke("methodToMock", "parameter1");
}