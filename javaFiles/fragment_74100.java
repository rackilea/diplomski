ActionListener timerListener = new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent evt) {

        jButton1.setBackground(Color.blue);
        timer.stop();
        defaultState.stop();
    }
};