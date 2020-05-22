private static final float HUE_MIN = 4f/6;
private static final float HUE_MAX = 5f/6;
…
    @Override
    public void actionPerformed(ActionEvent evt) {
        hue += delta;
        if (hue > HUE_MAX) {
            hue = HUE_MAX;
            delta = -delta;
        }
        if (hue < HUE_MIN) {
            hue = HUE_MIN;
            delta = -delta;
        }
        color1 = Color.getHSBColor(hue, 1, 1);
        color2 = Color.getHSBColor(hue, 3f/4 + delta, 3f/4 + delta);
        repaint();
    }