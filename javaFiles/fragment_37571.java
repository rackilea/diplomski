private void start() {
        //Here we initialize client variable
        client = new OkHttpClient();

        Request request = new Request.Builder().url("ws://192.168.1.84:81/").build();
        EchoWebSocketListener listener = new EchoWebSocketListener();

        // Then we could use it like so:
        WebSocket ws = client.newWebSocket(request, listener);    
        client.dispatcher().executorService().shutdown();
    }