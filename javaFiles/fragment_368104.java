private GridBagConstraints createGbc(int x, int y) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.fill = GridBagConstraints.HORIZONTAL; // stretch components horizontally
    gbc.weightx = 1.0;
    gbc.weighty = 0.0; // increase if you want component location to stretch vert.

    // I_GAP is a constant and is the size of the gap around
    // each component
    gbc.insets = new Insets(I_GAP, I_GAP, I_GAP, I_GAP);

    // if the x value is odd, anchor to the left, otherwise if even to the right
    gbc.anchor = x % 2 == 0 ? GridBagConstraints.WEST : GridBagConstraints.EAST;
    return gbc;
}