Socket s = serverSocket.accept();
InputStream in = s.getInputStream();
int firstbyte = in.read();
if(firstbyte = 0){
   //read text
}
else{
   //read file
}