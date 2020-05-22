public class CurrencyTest
{
    @Test
    public void testGetNumberFormatForCurrencyCode()
    {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        Currency currency = Currency.getInstance("USD");
        format.setCurrency(currency);

        System.out.println(format.format(1234.23434));
    }   
}