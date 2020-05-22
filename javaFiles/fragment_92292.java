bFaster.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          tM = 100;
          timer.stop();
          timer.setDelay( tM );
          timer.start();
        }
      });
    bSlower.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          tM = 1000;
          timer.stop();
          timer.setDelay( tM );
          timer.start();
        }
          });