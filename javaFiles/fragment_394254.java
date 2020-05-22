public class MyWebSocketHandlerDecpratorTest {
    @Mock
    private WebSocketSession session;

    @Mock
    WebSocketHandler delegate;

    private WebSocketHandlerDecorator webSocketHandlerDecorator;

    @InjectMocks
    MyWebSocketHandlerDecorator myWebSocketHandlerDecorator;

    private TextMessage message;

    @Before
    public void set_up(){
        MockitoAnnotations.initMocks(this);
        webSocketHandlerDecorator = Mockito.spy(new WebSocketHandlerDecorator(delegate));
        message = new TextMessage("Test Message".getBytes());
    }

    @Test
    public void handleMessage()throws Exception{
        myWebSocketHandlerDecorator.handleMessage(session, message);
        verify(webSocketHandlerDecorator, times(1)).handleMessage(session, message);
    }
}