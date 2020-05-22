redButton.setVisible(true);
Timer t = new Timer(1000, e -> {
    redButton.setVisible(false);
});
t.setRepeats(false);
t.start();