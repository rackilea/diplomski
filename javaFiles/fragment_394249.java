private static Timer timer;
boolean start = true;
boolean rest = false;
timer = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        l1.setText(Integer.toString(timeLeft / 60) + ":" + Integer.toString(timeLeft % 60));
        timeLeft--;
        if (timeLeft == 0) {
            if (rest) {
                timeLeft = workTime;
                JOptionPane.showMessageDialog(null, "Times Up!");
                rest = false;
            } else {
                timeLeft = restTime;
                JOptionPane.showMessageDialog(null, "Times Up!");
                rest = true;
            }
        }
    }
});
b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        if (start == true){
            timer.start();
            b1.setText("stop");
            start = false;
        } else if (start == false){
            timer.stop(); //the part that doesn't work
            b1.setText("start");
            start = true;
        }
    }
});