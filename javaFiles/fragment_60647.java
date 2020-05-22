public class releaseButton {

  private ReleaseButtonListener listener;
  public interface ReleaseButtonListener {
    void updateValue(int value);
  }

  public void setListener(ReleaseButtonListener listener) {
    this.listener = listener;
  }

  public void addButton(View button, TextView t, int value, final boolean increment){

    ...
    // when there is a change in the value, tell the listener.
    listener.updateValue(mValue);
  }
}