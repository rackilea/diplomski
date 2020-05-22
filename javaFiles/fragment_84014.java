public class MenuScreen extends List implements CommandListener{

     public MenuScreen() {
 append("Register", null);
     append("Login", null);
     append("Forgot password", null);


     select = new Command("Select", Command.OK, 1);
     addCommand(select);
     setCommandListener(this);