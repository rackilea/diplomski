public void sendResponse(String response) {
    OutputStream os = mClientSocket.getOutputStream();
    DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
    dos.writeUTF(response);
    dos.flush();
}