@Before
public void setup() {
    // create a myService mock
}

@Test
public void testMyFacadeMethodWithDataChange() {
    // change data, call tested method
    verify(myService).callServiceMethod();
}

@Test
public void testMyFacadeMethodWithoutDataChange() {
    // no data change, call tested method
    verify(myService, times(0)).callServiceMethod();
}