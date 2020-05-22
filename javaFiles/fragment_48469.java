public class MyInteger {
  private int x;
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void setX(int i) {
     int old = x;
     x = i;
     pcs.firePropertyChange("x", old, x); 
  }

  public void addListener(PropertyChangeListener l) {
      pcs.addListener("x", l);
  }
}