class MyWindowAdapter extends WindowAdapter {
  private CheckingAccountActions checkActions;

  public MyWindowAdapter(CheckingAccountActions checkActions) {
    this.checkActions = checkActions;
  }

  // in your window closing method
  // check the state of checkActions first before doing anything
    public void windowClosing(WindowEvent e) {
        // note -- don't check for saved in a static way
        // use a method on the instance.
        if(!checkActions.getSaved()) {
            // etc...
        }

        JFrame frame = (JFrame)e.getSource();
        frame.setVisible(false);

        // Main.frame.setVisible(false);
        System.exit(0);
    }
}