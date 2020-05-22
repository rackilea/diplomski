public static class Slave implements Runnable {
  ProcessExecutor pe;
  public void run () {
    try {
      pe._execute();
    } catch (Exception e) { pe.problemCallback(); }
  }
}

public class ProcessExecutor {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ProcessExecutor.class);

    private final String command;

    public ProcessExecutor(String command) {
        Validate.notBlank(command);
        this.command = command;
    }

    public void execute() {
        LOGGER.debug("Command that will be executed: {}",
                this.command);
        try {
            Slave s = new Slave();
            s.pe = this;
            Thread t = new Thread(s);
            t.start();
        } catch (IOException e) {
            LOGGER.error("Error restarting the process: {}",
                    e.getMessage());
        }
    }

    public void _execute() {
        ProcessBuilder pb = new ProcessBuilder ("/full/path/to/shell/script.sh");
        try {
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {}
    }
    public void problemCallback () {
        // do something with problem.
    }
}