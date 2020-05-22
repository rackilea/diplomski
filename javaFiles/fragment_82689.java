// Use the launcher of powermock
@RunWith(PowerMockRunner.class)
public class MyTestClass {

    @Test
    // Prepare the class for which we want to mock a static method
    @PrepareForTest(SiteUtil.class)
    public void myTest() throws Exception{
        // Build the mock of Site
        Site mockSite = PowerMockito.mock(Site.class);
        // Define the return values of the getters of our mock
        PowerMockito.when(mockSite.getId()).thenReturn(1);
        PowerMockito.when(mockSite.getBrand()).thenReturn("Google");
        // We use spy as we only want to mock one specific method otherwise
        // to mock all static methods use mockStatic instead
        PowerMockito.spy(SiteUtil.class);
        // Define the return value of our static method
        PowerMockito.when(SiteUtil.getSite()).thenReturn(mockSite);

        ...
    }
}