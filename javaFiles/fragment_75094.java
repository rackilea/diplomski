private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    // Start the Timer if it's not running.
    if (!myTimer.isRunning()) {
        jButton1.setIcon(new javax.swing.ImageIcon("./images/ic_four_times.png"));
        jButton1.setName("4x");
        jButton1.setText("4x Speed");
        speed = 1000;                   // Default (1x)
        myTimer.setDelay(speed);        // Set the Timer delay rate to the default
        myTimer.start();                // Start the Timer!
    }
    // Toggle Timer to 1x speed...
    else if (myTimer.isRunning() && jButton1.getName().equals("1x")) {
        jButton1.setIcon(new javax.swing.ImageIcon("./images/ic_four_times.png"));
        jButton1.setName("4x");
        jButton1.setText("4x Speed");
        speed = 1000;                   // Default (1x)
        myTimer.setDelay(speed);        // Set the Timer delay rate to 1x
    }
    // Toggle Timer to 4x speed...
    else {
        jButton1.setIcon(new javax.swing.ImageIcon("./images/ic_one_times.png"));
        jButton1.setName("1x");
        jButton1.setText("1x Speed");
        speed = 1000 / 4;               // Notice the division
        myTimer.setDelay(speed);        // Set the Timer delay rate to 4x
    }
}