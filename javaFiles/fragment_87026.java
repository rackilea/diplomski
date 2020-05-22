// ...
public void commandAction(Command c, Displayable d) 
{
    String label = c.getLabel();
    // log the event details; note Displayable.getTitle is available since MIDP 2.0
    log("command  s [" + label + "], screen is [" + d.getTitle() + "]");

    if(label.equals("ok"))
    {
        // log detection of the command
        log("command obtained, showing input");
        showInput();
    }
}

private void log(String message)
{
    // show message in emulator console
    System.out.println(message);
}
// ...