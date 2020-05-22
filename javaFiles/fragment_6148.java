public class ClientProcessor implements Runnable {

  public interface Server {
    void onResponseReceived(String response);
  }

  private Socket sock;
  private PrintWriter writer = null;
  private BufferedInputStream reader = null;
  public List<Dish> dish;
  // Your server instance
  private Server server;

  public ClientProcessor(Socket pSock) {
    this.sock = pSock;
  }

  public void run() {
    System.err.println("Lancement du traitement de la connexion cliente");

    boolean closeConnexion = false;
    while (!sock.isClosed()) {

      try {

        writer = new PrintWriter(sock.getOutputStream());
        reader = new BufferedInputStream(sock.getInputStream());

        String response = read();

        // report the response to TimeServer
        server.onResponseReceived(response);

        InetSocketAddress remote = (InetSocketAddress) sock.getRemoteSocketAddress();

        String debug = "";
        debug = "Thread : " + Thread.currentThread().getName() + ". ";
        debug += "Demande de l'adresse : " + remote.getAddress().getHostAddress() + ".";
        debug += " Sur le port : " + remote.getPort() + ".\n";
        debug += "\t -> Commande reçue : " + response + "\n";
        System.err.println("\n" + debug);

        String toSend = "";

        switch (response.toUpperCase()) {
          case "ORDER":
            toSend = "Dish";
            break;
          case "CLOSE":
            toSend = "Communication terminée";
            closeConnexion = true;
            break;
          default:
            toSend = "Commande inconnu !";
            break;
        }

        writer.write(toSend);
        writer.flush();

        if (closeConnexion) {
          System.err.println("COMMANDE CLOSE DETECTEE ! ");
          writer = null;
          reader = null;
          sock.close();
          break;
        }
      } catch (SocketException e) {
        System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
        break;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private void addServer(Server server) {
    this.server = server;
  }

  private void removeServer() {
    server = null;
  }

  // La méthode que nous utilisons pour lire les réponses
  private String read() throws IOException {
    String response = "";
    int stream;
    byte[] b = new byte[4096];
    stream = reader.read(b);
    response = new String(b, 0, stream);
    return response;
  }
}