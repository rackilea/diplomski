public FlashTimer() {

    javax.swing.Timer flashTimer = new javax.swing.Timer(500, new FlashHandler());
    flashTimer.setCoalesce(true);
    flashTimer.setRepeats(true);
    flashTimer.setInitialDelay(0);

}

public class FlashHandler implements ActionListener {

    private int counter;

    @Override
    public void actionPerformed(ActionEvent ae) {

        countrol.setVisible(counter % 2 == 0);
        counter++;
        if (counter > 3) {

            ((Timer)ae.getSource()).stop();

        }

    }

}