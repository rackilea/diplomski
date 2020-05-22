// define an interface
public interface ItemContainer {
  void addItem(StringBuilder item);
}

// change your Wrappers to implement the interface, i.e.
public class PrimaryWrapper extends ... implements ItemContainer {
  // ... your code, just add @Override annotation to the addItem(...) method
}
// and
public class SecondaryWrapper extends ... implements ItemContainer {
  // ... your code, just add @Override annotation to the addItem(...) method
}

// and finally, fix the AxisTag code
ItemContainer parent = (ItemContainer) getParent();
parent.addItem(axisItem);