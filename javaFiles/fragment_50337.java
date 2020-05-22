ChatFrame

import javax.swing.JTextArea;

public class ChatFrame {
    JTextArea textArea = null;

    void init(){
        //create and show UI here

        //Also start your message listener and give it the reference of textArea to be updated
        MessageListener messageListener = new MessageListener(this.textArea);
    }
}

MessageListener

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.swing.JTextArea;


public class MessageListener implements javax.jms.MessageListener {

    private JTextArea textArea = null;

    public MessageListener(JTextArea textArea){
        this.textArea = textArea;
        createConnection();
    }

    private void createConnection(){
        //Create your JMS Connection and add yourself as subscriber
    }

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