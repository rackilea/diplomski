private StringProperty promptText = new SimpleStringProperty(this, "promptText", "") {
    @Override protected void invalidated() {
        // Strip out newlines
        String txt = get();
        if (txt != null && txt.contains("\n")) {
            txt = txt.replace("\n", "");
            set(txt);
        }
    }
};