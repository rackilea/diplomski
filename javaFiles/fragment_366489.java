public static class MySB extends JScrollBar {
    private boolean inv;
    public MySB(int orient, int value, int extent, int min, int max, boolean inv) {
        super(orient, inv ? -value-extent : value, extent, inv ? -max : min, inv ? -min : max);
        this.inv = inv;
    }
    public int getAdjustedValue() {
        int v = super.getValue();
        if (inv)
            v = -(v + model.getExtent());
        return v;
    }
}