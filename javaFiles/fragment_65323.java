SpinnerModel saModel = new SpinnerNumberModel(11, 1, 36, 1);
  JSpinner saSpinner = new JSpinner(saModel);
  Dimension d = saSpinner.getSize();
  d.width = 20;
  saSpinner.setSize(d);

  JPanel panel = new JPanel();
  panel.add(new JLabel("Choose the key number for sa:"));
  panel.add(saSpinner);

  int selection = JOptionPane.showConfirmDialog(frame, panel, "Change Sa Key", 
          JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
  if (selection == JOptionPane.OK_OPTION) {
     System.out.println("Sa Key is: " + saModel.getValue().toString());
  }