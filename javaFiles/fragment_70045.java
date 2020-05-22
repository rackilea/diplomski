final WebSocketConnection connection = new WebSocketConnection();
try {
    connection.connect(url, new WebSocketHandler() {

        @Override
        public void onOpen() {
            // Web socket connection has been opened
        }

        @Override
        public void onTextMessage(String payload) {
            // Received text message
        }

        @Override
        public void onClose(int code, String reason) {
            // Web socket connection was closed
        }
    });
} catch (WebSocketException e) {
    Log.d(LOG_TAG, "Could not connect!", e);
}