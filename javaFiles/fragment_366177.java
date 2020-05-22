import java.beans.*;

public class Foo {

  private int bar;
  private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

  public int getBar() { return bar; }

  public void setBar(int bar) {
    int oldValue = this.bar;
    this.bar =  bar;
    pcs.firePropertyChange("bar", oldValue, bar);
  }

  public void addPropertyChangeListener(PropertyChangeListener pcl) {
    pcs.addPropertyChangeListener(pcl);
  }

  public void removePropertyChangeListener(PropertyChangeListener pcl) {
    pcs.removePropertyChangeListener(pcl);
  }
}