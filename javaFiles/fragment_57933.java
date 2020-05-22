Timer t;
int firecount = 0;    

int delay = 5000;
ActionListener taskPerformer = new ActionListener() {
  public void actionPerformed(ActionEvent evt) {        
    // action code
    firecount++;

    if ( firecount == 5 )
      t.stop();
};

t = new Timer(delay, taskPerformer).start();