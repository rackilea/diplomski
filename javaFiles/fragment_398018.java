import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class ChangeManager{
    private Set<ChangeListener> listenerSet = new HashSet<ChangeListener>();
    private volatile boolean stateChanged;
    private Timer timer = new Timer();
    private AtomicReference<MyJasonObject> currentJasonObjectState = new AtomicReference<MyJasonObject>();
    public void start(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                monitorValue();
            }

        }, 0, 1000);
    }
    public void monitorValue(){
        // Make Rest call and check if Jason object has changed and so update the stateChanged flag.
        stateChanged = hasStateChange();
        if(stateChanged){
            Iterator<ChangeListener> i = listenerSet.iterator();
            while(i.hasNext()) {
                i.next().notifyListener();
            }
            stateChanged = false;
        }
    }

    public void addListener(ChangeListener listener){
        listenerSet.add(listener);
    }

    public void removeListener(ChangeListener listener){
        listenerSet.remove(listener);
    }
}

interface ChangeListener {
    void notifyListener();
}