private void setup() {
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));  

    setupButtons();
    // setupButtonsActions();
    add(startButton);
    add(stopButton);
}

private void setupButtons() {
    // ...
    startButton.setHorizontalAlignment(JButton.CENTER);
    stopButton.setHorizontalAlignment(JButton.CENTER);
    startButton.setAlignmentY(CENTER_ALIGNMENT);  // **** change ****
    stopButton.setAlignmentY(CENTER_ALIGNMENT);  // **** change ****
}