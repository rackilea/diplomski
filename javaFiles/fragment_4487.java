new Timer().schedule(new TimerTask() {

    @Override
    public void run() {
        j.setText("Current Mouse Location: " + m.printLocation());
        c.setText(String.valueOf(m.getMouseColor()));
    }
}, 0, 200); // 200 milliseconds