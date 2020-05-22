/**
 * A JTextField that allows you to specify an array of KeyStrokes that
 * will have their bindings processed regardless of whether or
 * not they are registered on the JTextField itself. 
 */
public static class MultiplexingTextField extends JTextField {
    private KeyStroke[] strokes;
    private List<KeyStroke> keys;
    MultiplexingTextField(int cols, KeyStroke... strokes) {
        super(cols);
        this.keys = Arrays.asList(strokes);
    }

   @Override
    protected boolean processKeyBinding(KeyStroke ks, KeyEvent e,
                                        int condition, boolean pressed) {
        boolean processed = super.processKeyBinding(ks, e, condition,
                                                    pressed);

        if (processed && condition != JComponent.WHEN_IN_FOCUSED_WINDOW
                && keys.contains(ks)) {
            // Returning false will allow further processing
            // of the bindings, eg our parent Containers will get a
            // crack at them.
            return false;
        }
        return processed;
    }

}