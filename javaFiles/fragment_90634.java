private class WebSocketOrderClient extends WebSocketClient {
    public WebSocketOrderClient( URI serverUri, Draft draft, Map<String, String> headers, int timeout) {
        super( serverUri, draft, headers, timeout );
    }
    @Override
    public void onOpen( ServerHandshake handshakedata ) {
        Log.w("connected", "true");
    }
    @Override
    public void onMessage( String message ) {
        Log.w( "got: ", message );
    }
    @Override
    public void onClose( int code, String reason, boolean remote ) {
        Log.w( "Disconnected", ""+code  );
    }
    @Override
    public void onError( Exception ex ) {
        ex.printStackTrace();
    }
}