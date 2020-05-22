ws.setListener(new IPDWebSocket.MessageListener("disconnect", new MessageListener.MessageTriggerListener() {
            @Override
            public void onMessageReceived(String message) {
                Log.e("xx", "Received message: " + message);
            }
        }
        )
);