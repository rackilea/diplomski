InputStream in = new FileInputStream(file);
OuputStream os = socket.getOutputStream();
DataOutputStream dos = new DataOutputStream(os);
int n;
byte[] b = new byte[1024 * 16];
while ((n = in.read(b)) != -1)
{
    dos.writeByte(1); // tell the server a buffer is coming
    dos.writeInt(n); // tell it the how big the buffer is
    dos.write(b, 0, n); // write the buffer
}
dos.writeByte(0); // tell the server no more buffers are coming.
dos.flush();