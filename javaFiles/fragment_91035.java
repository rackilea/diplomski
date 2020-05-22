import javax.swing.Timer;

  public static void main(String[] args) {
                             /*this is 1 sec/ 1000ms*/
    Timer aiTimer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //move AI
            //repaint
        }
    });
    aiTimer.start();

}