client = new Client();
    Kryo kryo = client.getKryo();
    kryo.register(SRq.class);
    client.start();
    try {
        client.connect(6000, "localhost", 54555, 54777);
    } catch (Exception e) {
        System.err.println("Failed to connect to server!");
    }
    client.addListener(new Listener() {
        @Override
        public void received(Connection connection, Object object) {
            if(object instanceof SRq) {
                Gdx.app.log("Client", ((SRq) object).data);
            }
        }
    });
    System.out.println("Connected to server!");

    SRq sRq = new SRq();
    sRq.data = "Log in";
    client.sendTCP(sRq);