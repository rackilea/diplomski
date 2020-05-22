//to send
Socket s = ...
OutputStream os = s.getOutputStream();
if(messageIsText()){
  os.write(0);
  //send text
else{
  os.write(1); 
  //send file
}