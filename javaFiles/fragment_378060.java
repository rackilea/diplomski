public class ItemRegisterTest {
    @Test
    public void testIfHasRegisteredItemInStock() {
        Stock s = new Stock();
        assertTrue(s.getStock().size() == 0);
        ItemRegister i = new ItemRegister(s);        
        i.registerItem("Oleo", 20.0);
        assertTrue(s.getStock().size() == 1);
    }
}