public interface ProcessBuilderFactory {
    ProcessBuilder createProcessBuilder(String command);
}

public class DefaultProcessBuilderFactory implements ProcessBuilderFactory {
    public ProcessBuilder createProcessBuilder(String command) {
        return new ProcessBuilder(command);
    }
}

public class ProcessExecutor {
    private ProcessBuilderFactory processBuilderFactory;
    private ProcessExecutor(ProcessBuilderFactory processBuilderFactory) {
        this.processBuilderFactory = processBuilderFactory;
    }

    public void execute(String command) {
        ProcessBuilder processBuilder = processBuilderFactory.createProcessBuilder(command);
        Process process = processBuilder.start();

        int exitValue = process.waitFor();
        if (exitValue != 0) {
            throw new RuntimeException("a message here...");
        }
    }
}