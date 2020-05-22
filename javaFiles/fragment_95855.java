start_button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            start_button.setEnabled(false);
            stop_button.setEnabled(true);
            running = true;
            tl.setText("Running: " + running);
            while (running) {
                robot_loop(robot);
            }

        }
    });