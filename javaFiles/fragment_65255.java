stop.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ball2.stop();
        }
    });
    //...
    start.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ball2.start();
        }
    });