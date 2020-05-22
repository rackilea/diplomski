public class CustomMouseListener implements MouseMotionListener, MouseListener{

    private javax.swing.Timer moveTimer;
    private boolean moving = false;

    public CustomMouseListener() {
         moveTimer = new javax.swing.Timer(25, new ActionListener() {
                         public void actionPerformed(ActionEvent evt) {
                             moving = false;
                             // Method to be called when you want to
                             // to know when the mouse has stopped moving...
                         }
                     });
        moveTimer.setRepeats(false);
    }

    //whatever other methods I have (irrelevant for the question)

    public void mouseMoved(MouseEvent e){
        if (moving || moveTimer.isRunning()) {
            moveTimer.restart();
        } else {
            moving = true;
            moveTimer.start();
            // Method to call when you want to know when the mouse
            // has started moving...
        }
    }

}