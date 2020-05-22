@Mock
private BasketRepository basketRepo;

@Test
public void createBasketWithSameOrderRef() throws Exception
{
   basketService.setBasketRepository(basketRepo);
   ...