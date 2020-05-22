/*  
 *  You don't need spring context while mocking. 
 *  Hence No need to have spring runner. 
 */
@RunWith(MockitoJunitRunner.class)
public class TextHandlerTest {

    @Test
    public void verifyCallToIsOpenConnection() {
         WebSocketSession session = mock(WebSocketSession.class);
         TextMessage textMsg = new TextMessage("Test Message".getBytes());

         when(session.isOpen()).thenReturn(true);

         TextHandler textHandler = new TextHandler();

         // Pass the mocked session object here
         textHandler. handleTextMessage(session, textMsg);

         // Now you can verify if session.sendMessage() was called or not
         verify(session, times(1)).sendMessage(textMsg);
    }
}