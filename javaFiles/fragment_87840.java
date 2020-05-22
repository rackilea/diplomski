Thread repainter = new Thread(new Runnable() {
    @Override
    public void run() {
        while (true) { // I recommend setting a condition for your panel being open/visible
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ignored) {
            }
        }
    }
});
repainter.setName("Panel repaint");
repainter.setPriority(Thread.MIN_PRIORITY);
repainter.start();