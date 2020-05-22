public interface Command {
    public void execute();
}

public class MyCommand implements Command { 
    public void execute() {
        System.out.println("This is the output from MyCommand");
    }
}