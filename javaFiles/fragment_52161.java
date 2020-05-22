OutputStream os = socket.getOutputStream();
InputStream is = socket.getInputStream();
String response = "thump thump";

while(true){
    is.read();
    os.write(response.getBytes());
    os.flush();
}