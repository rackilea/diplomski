final KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
            manager.focusNextComponent();
        }

    }, 0, 500);