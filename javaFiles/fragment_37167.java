// "final" not required in Java 8 or later
void createTimer(int delay, final String hint, final Point location) {
    timer = new Timer();
    task = new TimerTask() {
        @Override
        public void run() {
            giveHint(hint, location);
        }
    };
    timer.schedule(task, delay);
}

void giveHint(String hint, CustomType location) {
  // Code to display hint at the given location
}