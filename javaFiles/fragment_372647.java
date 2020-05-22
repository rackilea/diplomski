infoLabel.setText("Added");

Timer timer = new Timer(300, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        infoLabel.setText("Action");
    }
});
timer.setRepeats(false);
timer.start();