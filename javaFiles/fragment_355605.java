@RunWith(JUnitParamsRunner.class)
public class BitcoinPricerTest {
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock (){
        //Arrange
        double price = 6000.00;
        double expected = price * 1.227481;
        BitCoinValueService bsp = Mockito.mock(BitCoinValueService.class);
        Mockito.when(bsp.findPrice()).thenReturn(price);
        BitCoinPricer bp = new BitCoinPricer(bsp);

        //Act
        double actual = bp.convertEuro();

        //Assert
        assertEquals(expected, actual, 1.0);
        Mockito.verify(bsp).findPrice();
    }
}