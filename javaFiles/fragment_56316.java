private void countDown() {
    // seconds--; // update seconds
    if (minutes == 0 && seconds == 0) {
        myTimer.stop(); // stop the Timer if time's up
        JOptionPane.showMessageDialog(null, "time's up!");
        new Result().setVisible(true);
        this.dispose();
    } else if (seconds == 0) {
        minutes--;
        seconds = 59;
    } else {
        seconds--;
    }

    // create label's text and update JLabel
    String text = String.format("%02d:%02d", minutes, seconds);
    lblTime.setText(text);
}