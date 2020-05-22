class Painter implements ActionListener () {
  int step = 0;
  Timer = this.timer;
  public void actionPerformed(ActionEvent ae) {
    if (step > ...) timer.stop();
    switch (step) {
       case 0 : ... ; break;
       case 1 : ... ; break;
    }
    step = step + 1;
  }
}

Timer timer = new Timer(new Painter(), 500);