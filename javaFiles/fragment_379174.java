public abstract class superclass {
  private int verySensitive;

  final int setVerySensitive(int val) {
    if (checkVerySensitive(val)) {
      verySensitive = val;
    }
  }
  protected abstract boolean checkVerySensitive(int val);
}


public class subclass extends superclass {

  @Override
  protected boolean checkVerySensitive(int val) {
    return val > threshLow && val < threshHigh; // threshHigh is calculated in superclass constructor
  }
}