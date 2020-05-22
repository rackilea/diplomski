Timer timer = new Timer(1200, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        if (count >= history.getTotalMoves() + 1) {
            timer.cancel();
            timer.purge();
            return;
        }
        history.next();
    }
});

timer.setRepeats(true);
timer.setCoalesce(true);
timer.setInitialDelay(1200);