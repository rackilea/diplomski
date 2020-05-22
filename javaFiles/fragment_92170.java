public void sendResponse(String response) {
    OutputStream os = mClientSocket.getOutputStream();
    DataOutputStream dos = new DataOutputStream(new GZIPOutputStream(os));
    byte[] buff = response.getBytes("UTF-8");
    dos.writeInt(buff.length);
    dos.write(buff);
    dos.flush();
}