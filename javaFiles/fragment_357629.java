package pkg2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.SwingWorker;

public class SwingWorkerWrapper extends SwingWorker<Integer, Void> {
    private ProcessLauncher processLauncher;

    public SwingWorkerWrapper(List<String> commands) {
        processLauncher = new ProcessLauncher(commands);
        processLauncher.addPropertyChangeListener(new LauncherListener());
    }

    @Override
    protected Integer doInBackground() throws Exception {        
        return processLauncher.call();
    }

    private class LauncherListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
        }
    }
}