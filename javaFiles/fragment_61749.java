public class Actions implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();//read the button asking for the request

        if (source.equals("Reset")) {
            textPad.setText("");
            if (timer.isRunning()) {
                timer.stop();
            }
        } else if (source.equals("Start")) {
            //first read the speed selected and set the speed 
            setSpeed(speedText.getText());
            startReader();
        } else if (source.equals("Stop")) {
            i = 0;
        }
        // This is stopping the timer AFTER it was already started
        //timer.stop();
    }
}