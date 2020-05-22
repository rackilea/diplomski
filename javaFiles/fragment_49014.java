ArrayList<ViewWasTouchedListener> listeners = new ArrayList<ViewWasTouchedListener>();

...

public void setWasTouchedListener(ViewWasTouchedListener listener){
    listeners.add(listener);
}