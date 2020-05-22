// not thread-safe
private JLabel getSomeLabel() {
    if (someLabel == null) {
        someLabel = new JLabel("Some label, huh");
        someLabel.addActionListener(...)
    }
    return someLabel;
}