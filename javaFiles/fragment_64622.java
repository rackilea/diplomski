public class GraphicViewImplTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private Graphics2D graphics; // not tested dependency
    @Mock
    private GraphicShape firstLine; // not tested dependency

    private GraphicViewImpl view; //This is my JPanel

    @Before
    public void setUp() throws Exception {
        view = spy(new GraphicViewImpl());
        doNothing().when(view).repaint();
    }

    @Test
    public void whenReceivingLine_shouldPaintLine() {
        view.receiveShape(firstGraphicLine);
        verify(view).repaint();
        verify(firstLine,never()).paint(graphics);

        view.paintComponent(graphics);
        verify(firstLine).paint(graphics);
    }
}