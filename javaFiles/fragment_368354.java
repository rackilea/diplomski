timer = new Timer(5, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        y1 = y1 - 1;
        if (y1 < 0) {
            y1 = 0;
            timer.stop();
        }
        jButton2.setLocation(x1, y1);
    }
});