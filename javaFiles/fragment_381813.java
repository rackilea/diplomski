timer = new Timer(10, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        long now = System.currentTimeMillis();
        long dif = now - startTime;
        if (dif >= runTime) {

            timer.stop();
            dif = runTime;

        }

        dif = runTime - dif;

        long minutes = dif / (60 * 1000);
        dif = Math.round(dif % (60 * 1000));
        long seconds = dif / 1000;
        dif = Math.round(dif % 1000);
        long centiseconds = dif / 10;

        timeLabel.setText(timeFormatter.format(minutes) + ":"
                + timeFormatter.format(seconds) + "."
                + timeFormatter.format(centiseconds));
    }
});