@Test
public void handleorderTest() {
    BusineesLayer layer = new BusineesLayer(); //we are testing this!
    DbService dbService = Mockito.mock(DbService.class);
    OrderModel orderModel = Mockito.mock(OrderModel.class);

    layer.dbService = dbService;
    layer.orderModel = orderModel;

    Mockito.when(orderModel.getItemsList()).thenReturn(new ArrayList<Items>());
    Mockito.when(dbService.foo()).thenReturn(true);

    //mock up multiple calls so your service will provide true

    boolean  res = layer.handleOrder();

    assertThat(res, equalTo(true));

    //repeat for false, and so on
}