public Combos() {
    super("ComboBox Example");
    setSize(800, 800);
    setLocationRelativeTo(null);
    add(configureBoxes());
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    boxThree.setEnabled(false);
    boxFour.setEnabled(false);

      ActionListener al = (ActionEvent e) -> {
        if (e.getSource() == boxTwo || e.getSource() == boxOne) {
            if (boxThree.isEnabled() && boxFour.isEnabled()) {
                boxThree.setEnabled(false);
                boxFour.setEnabled(false);
            } else {
                boxThree.setEnabled(true);
                boxFour.setEnabled(true);
            }
        }
    };

    boxOne.addActionListener(al);
    boxTwo.addActionListener(al);
}