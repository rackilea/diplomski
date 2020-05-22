durationTimer = new javax.swing.Timer(duration, new ActionListener() {               
    @Override
    public void actionPerformed(ActionEvent e) {       
        alert();
    }     
});                 

durationTimer.start();

//wait for duration to change
durationTimer.stop();
durationTimer.setDelay(duration);
durationTimer.start();