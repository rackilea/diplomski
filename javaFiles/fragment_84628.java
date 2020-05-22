public class SwingUnitTestingTest {

    @Rule
    public TestRule edt = new EDTRule();

    SwingUnitTesting sut;

    @Before
    public void setUp() throws Exception {
        sut = new SwingUnitTesting();
    }

    @Test
    public void btnNotRedBeforeKeypress() {
        assertNotEquals(Color.RED, sut.btn.getForeground());
    }

    @Test
    public void btnRedAfterKeypress() {
        sut.tf.requestFocusInWindow();
        sut.tf.dispatchEvent(
                new KeyEvent(sut.tf, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A'));
        assertEquals(Color.RED, sut.btn.getForeground());
    }
}