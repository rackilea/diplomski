public static class MultiplexingTextField extends JTextField {
    private List<KeyStroke> strokes;
    public MultiplexingTextField(int cols) {
        super(cols);
    }

    /**
     * Sets the KeyStrokes that will be additionally processed for
     * ancestor bindings.
     */
    public void addKeyStrokes(KeyStroke... keyStrokes) {
        for (KeyStroke keyStroke : keyStrokes) {
            getMultiplexingStrokes().add(keyStroke);
        }
    }

    private List<KeyStroke> getMultiplexingStrokes() {
        if (strokes == null) {
            strokes = new ArrayList<KeyStroke>();
        }
        return strokes;
    }

    @Override
    protected boolean processKeyBinding(KeyStroke ks, KeyEvent e,
                                        int condition, boolean pressed) {
        boolean processed = super.processKeyBinding(ks, e, condition,
                                                    pressed);

        if (processed && condition != JComponent.WHEN_IN_FOCUSED_WINDOW
                && getMultiplexingStrokes().contains(ks)) {
            // Returning false will allow further processing
            // of the bindings, eg our parent Containers will get a
            // crack at them.
            return false;
        }
        return processed;
    }
}