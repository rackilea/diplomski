public class BoardTest {

    private static final String OUT_OUT_BOUNDS_ERROR_MESSAGE = "Please choose a board size between 3 and 10";
    private static final String NFE_ERROR_MESSAGE = "Please enter a number";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Board board;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        board = new Board();
    }

    @Test
    public void setBoardSizeOf2EnsureErrorMessageDisplayed() {
        board.validateBoardSize("2");
        assertOutOfBoundsErrorMessageDisplayed();
    }

    private void assertOutOfBoundsErrorMessageDisplayed() {
        assertEquals(OUT_OUT_BOUNDS_ERROR_MESSAGE, outContent.toString().trim());
    }

    @Test
    public void setBoardSizeOf3EnsureNoErrorMessageDisplayed() {
        board.validateBoardSize("3");
        assertNoErrorMessageDisplayed();
    }

    private void assertNoErrorMessageDisplayed() {
        assertEquals("", outContent.toString().trim());
    }

    @Test
    public void setBoardSizeOf4EnsureNoErrorMessageDisplayed() {
        board.validateBoardSize("4");
        assertNoErrorMessageDisplayed();
    }

    @Test
    public void setBoardSizeOf9EnsureNoErrorMessageDisplayed() {
        board.validateBoardSize("9");
        assertNoErrorMessageDisplayed();
    }

    @Test
    public void setBoardSizeOf10EnsureNoErrorMessageDisplayed() {
        board.validateBoardSize("10");
        assertNoErrorMessageDisplayed();
    }

    @Test
    public void setBoardSizeOf11EnsureErrorMessageDisplayed() {
        board.validateBoardSize("11");
        assertOutOfBoundsErrorMessageDisplayed();
    }

    @Test
    public void setBoardSizeWithInvalidNumberEnsureInvalidNumberMessageDisplayed() {
        board.validateBoardSize("blah");
        assertInvalidNumberMessageDisplayed();
    }

    private void assertInvalidNumberMessageDisplayed() {
        assertEquals(NFE_ERROR_MESSAGE, outContent.toString().trim());
    }
}