public InlineGridBagConstraints reset() {
    gridx = 0;
    gridy = 0;
    gridheight = 1;
    gridwidth = 1;
    insets = new Insets(5, 5, 5, 5);
    fill = GridBagConstraints.BOTH;
    anchor = GridBagConstraints.CENTER;
    return this;
  }