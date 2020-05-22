@RunWith(MockitoJUnitRunner.class)
public class MessageWriterTest {

    @Mock
    private MessageGetter mockMessageGetter;

    @Mock
    private MessageDisplayer mockMessageDisplayer;

    @InjectMocks
    private MessageWriter messageWriter;

    @Test
    public void testWriteMessage() {
        String mockMessage = "Mock Hello";
        when(mockMessageGetter.getMessage()).thenReturn(mockMessage);
        messageWriter.writeMessage();
        verify(mockMessageDisplayer).displayMessage(mockMessage);
    }

}