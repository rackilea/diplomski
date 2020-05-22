@Override
public void onMessage(Message m) {
    try {
        TextMessage textMessage = (TextMessage) m;
        System.out.println("Received:" + textMessage.getText());
        jTextArea.apped(textMessage.getText());
    } catch (Exception e) {
        e.printStackTrace();
    }
}