public class MyTotalAwesomeController {

    WebSocketClient wsc = new WebSocketClient();

    // Queue for communication between threads.
    private BlockingQueue<String> queue;

    @PostConstruct
    void init() {

        queue = new SynchronousQueue<>(true);

        // This callback will be invoked by the WebSocket thread.
        wsc.addMessageHandler(new WebSocketClient.MessageHandler() {
            @Override
            public String handleMessage(String message) {
                System.out.println("RETURN MSG FROM WSS : " + message);
                // Pass message to the controller thread.
                queue.put(message);
                // Note that the return value is not necessary.
                // You can take it out of the interface as well.
                return null;
            }
        });
    }

    @RequestMapping(value="/add", method={RequestMethod.POST, RequestMethod.OPTIONS})
    public ResponseEntity<Object> putDataToMicroservice(@RequestBody Map<String, Object> payload, @RequestHeader(value = "authorization") String authorizationHeader) throws Exception {

        // At this point you make a WebSocket request, is that right?
        doWebSocketRequest();

        // This poll call will block the current thread
        // until the WebSocket server responds,
        // or gives up waiting after the specified timeout.
        //
        // When the WebSocket server delivers a response,
        // the WS client implementation will execute the
        // @OnMessage annotated method in a thread
        // managed by the WS client itself.
        //
        // The @OnMessage method will pass the message
        // to this thread in the queue below.

        String message = queue.poll(30, TimeUnit.SECONDS);

        if (message == null) {
            // WebSocket timeout.
        }

        return ResponseEntity.ok("worked");
    }
}