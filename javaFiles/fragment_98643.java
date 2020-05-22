// in main code
Bytestring message = new Bytestring(baos.toByteArray());
Send(message);

// send function
public void Send(Bytestring string) {
    OutputStream out = socket.getOutputStream();
    // other code for writing header
    out.write(string.getBytes());
    out.flush();
}