package pkg2;

import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProcessLauncher implements Callable<Integer> {
    private ExecutorService execService = Executors.newFixedThreadPool(2);
    private List<String> commands;
    private List<PropertyChangeListener> listeners = new ArrayList<>();

    public ProcessLauncher(List<String> commands) {
        this.commands = commands;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    @Override
    public Integer call() throws Exception {
        ProcessBuilder pb = new ProcessBuilder(commands);
        Process p = pb.start();
        int exitValue = 0;

        try (InputStream inputStream = p.getInputStream();
             InputStream errorStream = p.getErrorStream()) {

            StreamGobbler2 errorGobbler = new StreamGobbler2(inputStream, GobblerType.OUTPUT);
            StreamGobbler2 outputGobbler = new StreamGobbler2(errorStream, GobblerType.ERROR);

            for (PropertyChangeListener listener : listeners) {
                errorGobbler.addPropertyChangeListener(listener);
                outputGobbler.addPropertyChangeListener(listener);                
            }

            List<Future<Void>> futures = new ArrayList<>();
            futures.add(execService.submit(errorGobbler));
            futures.add(execService.submit(outputGobbler));
            execService.shutdown();

            exitValue = p.waitFor();
            for (Future<Void> future : futures) {
                future.get();
            }
        }

        return exitValue;
    }
}