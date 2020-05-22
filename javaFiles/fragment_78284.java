server = new Server();
    Kryo kryo = server.getKryo();
    kryo.register(SRq.class);
    server.start();
    try {
        server.bind(54555, 54777);
    } catch (Exception e) {
        System.err.println("Failed to bind to port!");
    }
    server.addListener(new Listener() {
        @Override
        public void received(Connection connection, Object object) {
            if(object instanceof SRq) {
                System.out.println("Server " +  ((SRq) object).data);
                SRq sRq = new SRq();
                sRq.data = "Data";
                connection.sendTCP(sRq);
            }
        }
    });