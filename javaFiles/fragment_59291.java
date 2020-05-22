int delay = 5000; //milliseconds
  ActionListener taskPerformer = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          System.out.println("This will run every 5 seconds");
      }
  };
  new javax.swing.Timer(delay, taskPerformer).start();