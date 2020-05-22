public class MyJob extends Job {

private static final String TASK_NAME = "Starting the Maven Command";

private String myFlag;
private String projectLocation;

private final PrintStream out = getConsole();
private final MavenCli cli = new MavenCli();

public MyJob(String myFlag, String projectLocation) {
    super(TASK_NAME);
    this.myFlag = myFlag;
    this.projectLocation = projectLocation;
}

@Override
protected IStatus run(IProgressMonitor monitor) {
    cli.doMain(new String[] {"test", "-DmyFlag=" + myFlag}, 
            projectLocation, out, out);
    return Status.OK_STATUS;
}

private PrintStream getConsole() {
    MessageConsole console = findMessageConsole("Console");
    console.activate();
    return new PrintStream(console.newOutputStream());
}

private MessageConsole findMessageConsole(String title) {
    IConsole[] existingConsoles = ConsolePlugin.getDefault().getConsoleManager().getConsoles();
    for (IConsole existingConsole : existingConsoles) {
        if (existingConsole.getName().equals(title)) {
            return (MessageConsole) existingConsole;
        }
    }
    MessageConsole console = new MessageConsole(title, null);
    ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] {console});
    return console;
}