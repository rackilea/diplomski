@ServerEndpoint("/data")
public static class Handler {

    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    @OnMessage
    public void onMessage(byte[] message) throws IOException {
        buffer.write(message);
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println(
            buffer.toByteArray().length
        );
    }

}