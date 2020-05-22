private void setupAddressForm() {
      frame.getContentPane().removeAll(); // (B)

      JPanel infoPanel = new JPanel();
      JLabel infoLabel = new JLabel();
      infoLabel.setText("<html><B>Please enter the address below</B></html>");
      infoPanel.add(infoLabel, SwingConstants.CENTER);
      frame.getContentPane().add(infoPanel, BorderLayout.NORTH); // (C)