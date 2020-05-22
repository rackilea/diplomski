public class MyPrompter implements CommandListener {

    private Alert yesNoAlert;

    private Command softKey1;
    private Command softKey2;

    private boolean status;

    public MyPrompter() {
        yesNoAlert = new Alert("Attention");
        yesNoAlert.setString("Are you sure?");
        softKey1 = new Command("No", Command.BACK, 1);
        softKey2 = new Command("Yes", Command.OK, 1);
        yesNoAlert.addCommand(softKey1);
        yesNoAlert.addCommand(softKey2);
        yesNoAlert.setCommandListener(this);
        status = false;
    }

    public Displayable getDisplayable() {
        return yesNoAlert;
    }

    public boolean getStatus() {
        return status;
    }

    public void commandAction(Command c, Displayable d) {
        status = c.getCommandType() == Command.OK;
        // maybe do other stuff here. remember this is asynchronous
    }

};