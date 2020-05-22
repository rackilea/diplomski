BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
while (true) {
    String msg = console.readLine();
    if (msg == null) {
        break;
    } else if ("bye".equals(msg.toLowerCase())) {
        ch.writeAndFlush(new CloseWebSocketFrame());
        ch.closeFuture().sync();
        break;
    } else if ("ping".equals(msg.toLowerCase())) {
        WebSocketFrame frame = new PingWebSocketFrame(Unpooled.wrappedBuffer(new byte[] { 8, 1, 8, 1 }));
        ch.writeAndFlush(frame);
    } else {
        WebSocketFrame frame = new TextWebSocketFrame(msg);
        ch.writeAndFlush(frame);
    }
}