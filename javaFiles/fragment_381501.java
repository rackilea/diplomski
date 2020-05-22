int delay = 1000; //milliseconds
ActionListener taskPerformer = new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        randomness();
    }
};
new Timer(delay, taskPerformer).start();