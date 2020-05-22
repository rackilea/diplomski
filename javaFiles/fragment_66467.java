laserOnOff.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!laserSetting) {
            timeOfLastButtonPress = Instant.now();
            timer.start();
            laserSetting = true;
            laserOnOff.setText("Laser On");
        } else {
            timer.stop();
            laserSetting = false;
            laserOnOff.setText("Laser Off");
        }
    }
});