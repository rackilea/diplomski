public class YourClass implements MessageListener {
@Override 
public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                inputJsonString = textMessage.getText();
               //do what ever you want with inputJsonString
                message.acknowledge(); 
           }