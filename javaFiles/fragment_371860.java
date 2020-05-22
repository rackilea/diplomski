import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

interface MarkerListener
{
    void delayChanged(double oldDelay, double newDelay);
}

class Marker
{
    private double delay;

    private final List<MarkerListener> markerListeners = 
        new CopyOnWriteArrayList<MarkerListener>();

    void addMarkerListener(MarkerListener markerListener)
    {
        markerListeners.add(markerListener);
    }

    void removeMarkerListener(MarkerListener markerListener)
    {
        markerListeners.add(markerListener);
    }

    void setDelay(double newDelay)
    {
        if (newDelay != this.delay)
        {
            double oldDelay = this.delay;
            this.delay = newDelay;
            fireDelayChanged(oldDelay, newDelay);
        }

    }

    private void fireDelayChanged(double oldDelay, double newDelay)
    {
        for (MarkerListener markerListener : markerListeners)
        {
            markerListener.delayChanged(oldDelay, newDelay);
        }
    }
}