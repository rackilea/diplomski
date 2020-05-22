@Test
public void test(
    @Mocked final ServiceData mockServiceData, @Mocked final Data mockData,
    @Mocked final Container mockContainer)
{
    // only stubbing some of the methods
    new Expectations(mockContainer) {{
        mockContainer.someMethod(); result = "something";
        mockServiceData.getContainer(); result = mockContainer;
        mockServiceData.getDataAt((Index) any); result = mockData;
    }};

    // some assertions
}