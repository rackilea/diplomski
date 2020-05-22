int delay = 1000; //milliseconds
  ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          label.setText("foo");
      }
  };
  new Timer(delay, taskPerformer).start();