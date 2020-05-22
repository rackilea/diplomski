public class ExampleThreadTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForInvalidNumber() {
        ExampleThread exThread = new ExampleThread(-1);
        exThread.run();
    }
}