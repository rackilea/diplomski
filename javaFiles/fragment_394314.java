java.util.Timer timer = new java.util.Timer();

ActionListener listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                //code to execute repeatedly
            }
        }, 0, 0);
};