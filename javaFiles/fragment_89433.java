int delay = 1000; //milliseconds
ActionListener taskPerformer = new ActionListener() {
  public void actionPerformed(ActionEvent evt) {
    actionAI();
  }
};
Timer timer = new Timer(delay, taskPerformer)
timer.setRepeats(false);
timer.start();