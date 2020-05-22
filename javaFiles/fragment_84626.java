public class SwingUnitTestingTest {

    SwingUnitTesting sut;

    @Before
    public void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            sut = new SwingUnitTesting();
        });
    }

    @Test
    public void btnNotRedBeforeKeypress() throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            assertNotEquals(Color.RED, sut.btn.getForeground());
        });
    }

    @Test
    public void btnRedAfterKeypress() throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            sut.tf.requestFocusInWindow();
            sut.tf.dispatchEvent(new KeyEvent(sut.tf,
                    KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0,
                    KeyEvent.VK_UNDEFINED, 'A'));
            assertEquals(Color.RED, sut.btn.getForeground());
        });
    }
}