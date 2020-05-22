public void run() {
try {
    ServerSocket serverSocket= new ServerSocket(44444);//inside there is the port mumber which will be gain later from firstscreen
    Socket clientSocket= serverSocket.accept();
    DataOutputStream OUT =  new DataOutputStream(clientSocket.getOutputStream());
    DataInputStream IN = new DataInputStream(clientSocket.getInputStream());
    while (true){
        String input = IN.readUTF();
        textArea.append(input+"\n"); //update the textarea
    }//loop end

}catch (IOException e){
    //joptionpane
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    //joptionpane
    e.printStackTrace();
}   
}//end of try



public void actionPerformed(ActionEvent e) {
  if(e.getActionCommand().equals("Send")|| e.getSource() instanceof JTextField) {
    try {
        if(!textField.getText().isEmpty()) { //Do not forget to include the ! (NOT)
            OUT.writeUTF(textField.getText());
            textArea.setText(textArea.getText()+"Assistant:"+textField.getText()+"\n");
        }    
    }
    catch (IOException c){
        c.printStackTrace();
    }
 }

}