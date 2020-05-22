public void send(String message, boolean textB){
if(message.equals("")) return;
if(textB){
    message = client.getName() + ": " + message;
    message = "/m/"+message;
}
client.send(message.getBytes());
text.setText("");
text.requestFocusInWindow();