public class AlieniTest {

    @Test
    public void testAlieni() {
        Settore settore = new Alieni(3,10);
        assertEquals(Nome.ALIENI, settore.getSettoreNome());
    }
}