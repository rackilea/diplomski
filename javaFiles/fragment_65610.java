public final class StopServerCommand implements Command {
    private final Server server;

    public StopServerCommand(Server server) { this.server = server; }

    public void execute() {
        if(server.isRunning()) server.stop();
    }
}

public class Application {
    //...
    public void someMethod() {
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(Event e) {
                 stopCommand.execute();
            }
        });
    }
}