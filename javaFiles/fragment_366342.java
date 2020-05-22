@Test
public void getAllOrdersAPI() throws Exception {
   Order order = create expected order object
   when(service.findAll()).thenReturn(Arrays.asList(order));
   // rest of the test
}