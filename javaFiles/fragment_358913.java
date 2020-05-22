public class FixedBoundsColorDrawable extends ColorDrawable {
  private boolean mFixedBoundsSet = false; // default

  public FixedBoundsColorDrawable(int color) {
    super(color);
  }

  @Override
  public void setBounds(int left, int top, int right, int bottom) {
    if (!mFixedBoundsSet) {
      mFixedBoundsSet = true;
      super.setBounds(left, top, right, bottom);
    }
  }
}