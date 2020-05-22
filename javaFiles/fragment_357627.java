package pkg2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class StreamGobbler2 implements Callable<Void> {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private InputStream is;
    private GobblerType type;
    private String text;

    public StreamGobbler2(InputStream is, GobblerType type) {
        this.is = is;
        this.type = type;
    }

    @Override
    public Void call() throws Exception {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            setText(line);
        }
        return null;
    }

    public GobblerType getType() {
        return type;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void setText(String text) {
        String oldValue = null;
        String newValue = text;
        this.text = text;
        support.firePropertyChange(type.toString(), oldValue, newValue);
    }

    public String getText() {
        return text;
    }

}