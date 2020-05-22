// abstraction 
abstract class Logger {
    protected final LogOutputter outputter;
    public abstract void log(String message);
}

// abstraction extension
class ErrorLogger extends Logger {
    public void log(String message) {
        outputter.output("Error: " + message);
    }
}

// implementation interface
interface LogOutputter {
    void output(String message);
}

// implementation extensions
class FileLogOutputter implements LogOutputter ...
class ConsoleLogOutputter implements LogOutputter ...