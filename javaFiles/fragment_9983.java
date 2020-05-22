JFileChooser chooser = new JFileChooser();
    int option = chooser.showOpenDialog(SimpleFileChooser.this);
    if (option == JFileChooser.APPROVE_OPTION) {
      statusbar.setText("You opened " + ((chooser.getSelectedFile()!=null) ? chooser.getSelectedFile().getName():"nothing"));
    }
    else {
      statusbar.setText("You canceled.");
    }