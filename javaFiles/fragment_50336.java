import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.swing.JTextArea;


public class ChatFrame {
    JTextArea textArea = null;

    void init(){
        //create and show UI here
    }

    class MessageListener implements javax.jms.MessageListener {
        @Override
        public void onMessage(Message arg0) {
            TextMessage textMessage = (TextMessage)arg0;
            try {
                textArea.append(textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}