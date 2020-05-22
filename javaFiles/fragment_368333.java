public void actionPerformed(ActionEvent e) {
     JButton source = (JButton) e.getSource();
     if (selectedButtons.contains(source)) {
        source.setText(NUGGET);
        source.setBackground(Color.yellow);
     } else {
        source.setText(MISSED);
     }
  }