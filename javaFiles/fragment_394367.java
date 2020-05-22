@OnWebSocketFrame
@SuppressWarnings("unused")
public void onFrame(Frame pong) {
    if (pong instanceof PongFrame) {
        lastPong = Instant.now();
    }
}