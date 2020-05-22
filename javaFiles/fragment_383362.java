public class CustomTextArea extends TextArea {

    private static final PseudoClass UNDERLINED = PseudoClass.getPseudoClass("underlined");

    private final BooleanProperty underlined = new SimpleBooleanProperty(this, "underlined") {
        @Override
        protected void invalidated() {
            pseudoClassStateChanged(UNDERLINED, get()); // update PseudoClass state to match 
                                                        // the current value of the property
        }
    };

    // property access methods

    public final void setUnderlined(boolean underlined) {
        this.underlined.set(underlined);
    }

    public final boolean isUnderlined() {
        return underlined.get();
    }

    public final BooleanProperty underlinedProperty() {
        return underlined;
    }

    // constructor      

    public CustomTextArea(String text, boolean underlined) {
        super(text);
        setUnderlined(underlined);
        getStyleClass().add("custom-text-area"); // to allow specific CSS styling
    }

}