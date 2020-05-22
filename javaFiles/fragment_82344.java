public Starter() {

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        new Thread() {
          public void run() {
            OneClass.getInstance().start();
          }
        }.start();
      }
    });
    add(button);
  }