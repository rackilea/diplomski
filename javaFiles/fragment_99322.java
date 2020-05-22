public class DialogSubsystemLayoutFrame extends JFrame {
  // You store the reference here.
  private SocketConnectionThread socketConnection = null;

  public DialogSubsystemLayoutFrame(SocketConnectionThread socket) {
    this.socketConnection = socket;
  }
}