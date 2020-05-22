public class PokerClient {
  private final PokerClientGui gui;
  private final Socket clientSocket;
  private final ObjectOutputStream outObjects;
  private final ObjectInputStream inObjects;

  public PokerClient(PokerClientGui gui) throws IOException {
    this.gui = gui;
    clientSocket = new Socket("localhost", 4444);
    outObjects = new ObjectOutputStream(clientSocket.getOutputStream());
    outObjects.flush();
    inObjects = new ObjectInputStream(clientSocket.getInputStream());
  }
}