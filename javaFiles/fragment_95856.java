start_button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            start_button.setEnabled(false);
            stop_button.setEnabled(true);
            running = true;
            tl.setText("Running: " + running);
            Executors.newSingleThreadExecutor().submit(new Runnable() {
                @Override public void run() {
                    while (running) {
                        robot_loop(robot);
                    }
                }
            });
        }
    });