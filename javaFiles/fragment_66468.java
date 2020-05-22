Timer timer = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Duration elapsedTime =
            Duration.between(timeOfLastButtonPress, Instant.now());
        laserOnTimeTF.setText(String.format("%02d:%02d:%02d",
            elapsedTime.toHoursPart(),
            elapsedTime.toMinutesPart(),
            elapsedTime.toSecondsPart()));
    }
});