Piece[] pieces = new Piece[]{
    // Create what ever pieces you need...
}
DefaultComboBoxModel modelPlayer1 = new DefaultComboBoxModel(pieces);
DefaultComboBoxModel modelPlayer2 = new DefaultComboBoxModel(pieces);

JComboBox cbPlayer1 = new JComboBox(modelPlayer1);
JComboBox cbPlayer2 = new JComboBox(modelPlayer2);