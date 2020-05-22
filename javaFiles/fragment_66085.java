public class ClientController() {
     // ClientPlayer clientPlayer = new ClientPlayer();

    public void connect(ClientPlayer clientPlayer) {
    if (client.isConnected()) {
        Logger.getLogger(getClass().getName()).log(Level.INFO, "You are      already connected to :{0}", config.getHost());
        return;
    }
    this.client.start();
    try {
        this.client.connect(5000, config.getHost(), config.getTCPPort());
        System.out.println("Successfully connected to " + config.getHost());
        this.client.sendTCP(clientPlayer.getPlayerName());

    } catch (IOException ex) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Server connection failed: {0}", ex.getMessage());
        throw new RuntimeException(ex);
    }

    MessageRegistry.registerMessages(client.getKryo());
    this.client.addListener(listener);
  }
 }