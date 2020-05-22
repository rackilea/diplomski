BufferedReader reader = new BufferedReader(new FileReader(log));
JLabel validator = new JLabel("Validating  - please wait");
JOptionPane pane = new JOptionPane(validator, JOptionPane.INFORMATION_MESSAGE,JOptionPane.NO_OPTION,null, new String[]{"Close"});
final JDialog dialog = pane.createDialog(null, "title");
dialog.setModal(true);

SwingWorker myWorker = new SwingWorker<String, Void>() {
  public void doInBackground() {
     // do long running process
     // perhaps including
     writer = validate(reader);

     // ....

     return yourString;
  }

  public void done() {  
    update JLabel
    dispose of dialog here!
  }
};
myWorker.execute();
dialog.setVisible(true);