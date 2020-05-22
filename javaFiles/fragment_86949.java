public class WampusGUI extends JFrame {
   public static final String USER_COMMAND = "user command";
   // ....

   private void setUserCommand(String userCommand) {
      String oldValue = this.userCommand;
      String newValue = userCommand;
      this.userCommand = userCommand;
      firePropertyChange(USER_COMMAND, oldValue, newValue);
   }