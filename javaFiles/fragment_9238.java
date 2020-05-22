javax.swing.Timer timer = new javax.swing.Timer(17, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        ball1.runMe();
    }
});
timer.start();