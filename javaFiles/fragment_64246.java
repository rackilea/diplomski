public class Prova {
    private static final int ROWS = 6;
    private static final int COLS = 7;

    // ....

            lblCircles[i].addMouseListener(new MouseAdapter() {
                // better to use mousePressed, not mouseClicked
                public void mousePressed(MouseEvent e) {

                    // no magic numbers such as 42 please. 
                    for (int i = 0; i < lblCircles.length; i++) {
                        if (e.getSource() == lblCircles[i] && choose == 1) {
                            myLabelClicked(lblCircles[i], i);
                        }
                    }
                }
            });