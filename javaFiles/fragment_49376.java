private void configInputPanel() {

    JPanel trickPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
    JLabel label1 = new JLabel("Wing Area (m");
    JLabel supLabel = new JLabel("2");
    Font font = label1.getFont();
    supLabel.setFont(font.deriveFont(font.getSize() / 1.5f));
    trickPanel.add(label1);
    trickPanel.add(supLabel);
    trickPanel.add(new JLabel(")"));

    configInputPanel = new JPanel(new GridBagLayout());
    gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(0, 5, 0, 5);
    gbc.gridx = 0;
    configInputPanel.add(new JLabel("Fuselage Length (m)"), gbc);
    configInputPanel.add(new JLabel("Fuselage Width (m)"), gbc);
    configInputPanel.add(new JLabel("Fuselage Height (m)"), gbc);
    configInputPanel.add(new JLabel("Wing Span (m)"), gbc);
    configInputPanel.add(trickPanel, gbc);
    configInputPanel.add(new JLabel("Wing Sweep (degree)"), gbc);
    configInputPanel.add(new JLabel("Nose Gear to Fuselage Tip (m)"), gbc);
    configInputPanel.add(new JLabel("Main Gear to Nose Gear (m)"), gbc);
    configInputPanel.add(new JLabel("Main Gear Separation (m)"), gbc);
    configInputPanel.add(new JLabel("Body Gear to Nose Gear (m)"), gbc);
    configInputPanel.add(new JLabel("Body Gear Separation (m)"), gbc);
    configInputPanel.add(new JLabel("Engine to Centerline (m)"), gbc);

    gbc.gridx = 1;
    for (int i = 0; i < 12; i++) {
        JTextField textfield = new JTextField(5);
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        configInputPanel.add(textfield, gbc);
    }
}