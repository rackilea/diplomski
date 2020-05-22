public static void startTimer() {
    listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.print("action");
            timerLabel.setText("" + seconds);
            seconds--;
            System.out.println(seconds);
            if (seconds < 0){
                System.out.print("zero");
                wrong();
            }
        }
    };
    displayTimer = new Timer(1000, listener);
    displayTimer.setInitialDelay(1);
    displayTimer.start();

    if (right == true){
        System.out.print("true");
        displayTimer.stop();
        right = false;
        seconds = 30;
        displayTimer = new Timer(10000, listener);
        displayTimer.setDelay(10000);
        displayTimer.setInitialDelay(1);
        displayTimer.start();
    }
    else if (right == null){
        System.out.print("null");
        displayTimer.stop();
        seconds = 30;
        displayTimer = new Timer(10000, listener);
        displayTimer.setInitialDelay(1);
        displayTimer.setDelay(10000);
        displayTimer.start();
    }
}