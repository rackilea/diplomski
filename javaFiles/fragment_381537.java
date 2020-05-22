gbc.gridx = 0;
for (int i = 0; i < ELEMENTS; i++) {
    if (i % 3 == 0) {
        gbc.gridy += 2;
        gbc.gridx = 0;
    }
    pane.add(foodLabel[i], gbc);
    gbc.gridy++;
    pane.add(qtyField[i], gbc);
    gbc.gridx++;
    gbc.gridy--;
}