public class StateDrawable extends LayerDrawable {

    public StateDrawable(Drawable[] layers) {
        super(layers);
    }

    @Override
    protected boolean onStateChange(int[] states) {
        for (int state : states) {
            if (state == android.R.attr.state_selected) {
                super.setColorFilter(Color.argb(255, 255, 195, 0), PorterDuff.Mode.SRC_ATOP);
            } else {
                super.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
            }
        }
        return super.onStateChange(states);
    }

    @Override
    public boolean isStateful() {
        return true;
    }

}