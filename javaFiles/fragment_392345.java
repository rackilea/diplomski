java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        movingClock.setText(hour + ":" + minute + ":" + second);
        movingClock.setBounds(x, y, 150, 150);
    }
} );