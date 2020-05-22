final Socket socket = IO.socket("http://localhost:3000",opts);

    socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            socket.emit("message","hello from java");
        }
    });


    socket.on("message", new Emitter.Listener() {

        @Override
        public void call(Object... args) {
            byte[] bytearray = (byte[])args[0]; //received bytes

            for  (byte b : bytearray) {
                System.out.println("byte"+b);
            }
        }

    });

   socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
    @Override
    public void call(Object... args) {}
});