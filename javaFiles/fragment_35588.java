final Timer t = new Timer(1000, new ActionListener() {
    private long time = 10 * 1000; //10 seconds, for example

    public void actionPerformed(ActionEvent e) {
        if (time >= 0) {
            long s = ((time / 1000) % 60);
            long m = (((time / 1000) / 60) % 60);
            long h = ((((time / 1000) / 60) / 60) % 60);
            timing.setText(h + " hours, " + m + " minutes " + s + " seconds");
            time -= 1000;
        }
    }
});
t.start();