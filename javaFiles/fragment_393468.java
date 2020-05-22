public StompSession createStompWSConnection(String socketURL, StompSessionHandler sessionHandler) throws Exception  {
        List<Transport> transports = new ArrayList<Transport>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
//      transports.add(new RestTemplateXhrTransport());

        SockJsClient sockJsClient = new SockJsClient(transports);
        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new SimpleMessageConverter());

        StompSession session = stompClient.connect(socketURL,sessionHandler).get();
        System.out.println("Session : " + session);
        return session;
    }