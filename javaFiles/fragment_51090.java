gbc_tglbtnNewToggleButton.fill = GridBagConstraints.VERTICAL;
gbc_tglbtnNewToggleButton.insets = new Insets(0, 0, 5, 5);
gbc_tglbtnNewToggleButton.gridy = j;
for (int i = 0; i < 100; i++) {
    JToggleButton button = new JToggleButton("");
    buttons.add(button);
    gbc_tglbtnNewToggleButton.gridx = i;
    buttons.add(button, gbc_tglbtnNewToggleButton);
}