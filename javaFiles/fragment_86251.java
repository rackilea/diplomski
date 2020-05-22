private void addButton() {
    button = new JButton("Click Me");
    final ActionListener off = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            setDefaultCursor();
            button.setEnabled(true);
        }

    };
    button.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            setWaitCursor();
            button.setEnabled(false);
            Timer timer = new Timer(2000, off);
            timer.setRepeats(false);
            timer.start();
        }
    });

    add(button, BorderLayout.NORTH);
}