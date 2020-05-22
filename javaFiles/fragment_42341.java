/* Write byte array */
OutputStream out = socket.getOutputStream(); 
DataOutputStream dos = new DataOutputStream(out);
int length = msgBytes.length;
dos.writeInt(length);
if (length > 0) {
    dos.write(msgBytes);
}

/*Read byte array */
DataInputStream dis = new DataInputStream(socket.getInputStream());
int length = dis.readInt();                   
if(length>0) {
    byte[] msgBytes = new byte[length];
    dis.readFully(msgBytes, 0, length); 
}