public class ProcessManager extends Thread {
    private ProcessBuilder processBuilder;
    private Process process;
    private List<ProcessEventListener> processEventListeners = new ArrayList<ProcessEventListener>();

    public ProcessManager(String externalProcessPath, List<String> args) {
        args.add(0, externalProcessPath);
        processBuilder = new ProcessBuilder(args);
    }

    public ProcessManager(String externalProcessPath) {
        processBuilder = new ProcessBuilder(externalProcessPath);
    }

    public Process getProcess() {
        return process;
    }

    public void run() {
        try {
            process = processBuilder.start();
            // wait until the process is completed
            process.waitFor(); 
            // let the listeners know since the process is completed
            for (ProcessEventListener listener : processEventListeners) {
                listener.onComplete(process);
            }
        } catch (InterruptedException e) {}
    }

    public void addProcessEventListener(ProcessEventListener processEventListener) {
        processEventListeners.add(processEventListener);
    }

    public void removeAllListeners() {
        processEventListeners.clear();
    }
}