@Override
public void handleMessage(Message msg) {
    String message = (String) msg.obj; //Extract the string from the Message
    textView.setText(message);
    //....
}