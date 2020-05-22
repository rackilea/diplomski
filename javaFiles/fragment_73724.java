public TaskTimer() {

    ActionListener go = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count();
        }
    };

    timer = new Timer(UNIT, go);
}

public void start() {
    timer.start();
}