private void setup() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // **** change ****

    setupButtons();
    // setupButtonsActions();
    add(startButton);
    add(stopButton);
}

private void setupButtons() {
    // ...
    startButton.setHorizontalAlignment(JButton.CENTER);
    stopButton.setHorizontalAlignment(JButton.CENTER);
    startButton.setAlignmentX(CENTER_ALIGNMENT);
    stopButton.setAlignmentX(CENTER_ALIGNMENT);
}