public void actionPerformed(ActionEvent e) {
     if (!(puzzle.isLegal())) {
       JOptionPane.showMessageDialog(FutoshikiFrame.this,
         formattedString,
         "You made a mistake!",
         JOptionPane.INFORMATION_MESSAGE);