button.getModel().addChangeListener(evt -> {
    ButtonModel model = (ButtonModel) evt.getSource();
    Font btnFont = button.getFont();
    Map attributes = btnFont.getAttributes();

    if (model.isRollover()) {
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
    } else {
        attributes.put(TextAttribute.UNDERLINE, null);
    }
    btnFont = btnFont.deriveFont(attributes);
    button.setFont(btnFont);
});