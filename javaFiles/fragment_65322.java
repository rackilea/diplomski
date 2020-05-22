SpinnerModel saModel = new SpinnerNumberModel(11, 1, 36, 1);
  JSpinner saSpinner = new JSpinner(saModel);
  Dimension d = saSpinner.getSize();
  d.width = 20;
  saSpinner.setSize(d);

  // Object[] message = { "Choose the key number for sa.", saSpinner };

  JPanel panel = new JPanel();
  panel.add(new JLabel("Choose the key number for sa:"));
  panel.add(saSpinner);

  JOptionPane optionPane = new JOptionPane(panel,
          JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
  JDialog dialog = optionPane.createDialog(frame, "Change Sa Key");
  dialog.setVisible(true);