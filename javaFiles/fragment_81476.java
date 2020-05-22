ActionListener listener = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            if (x >= D_W) {
                x = 0;
                drawPanel.repaint();
            } else {
                x += 10;
                drawPanel.repaint();
            }
        }
    };
    Timer timer = new Timer(250, listener);
    timer.start();