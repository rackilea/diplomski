JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JTabbedPane pane = new JTabbedPane();

    JPanel jPanel = new JPanel();
    JButton button = new JButton("Blink tab");
    jPanel.add(button);
    pane.addTab("adsad", jPanel);

    JPanel jPanel1 = new JPanel();
    jPanel1.add(new JLabel("hi"));
    pane.addTab("werqr", jPanel1);

    final Color defaultBackColor = pane.getBackgroundAt(1); // default background color of tab
    final Color defaultForeColor = pane.getForegroundAt(1); // default foreground color of tab

    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Timer timer = new Timer(500, new ActionListener() {
                boolean blinkFlag = false;
                @Override
                public void actionPerformed(ActionEvent e) {
                    blink(blinkFlag);
                    blinkFlag = !blinkFlag;
                }
            });
            timer.start();
        }
        private void blink(boolean blinkFlag) {
            if (blinkFlag) {
                pane.setForegroundAt(1, Color.green);
                pane.setBackgroundAt(1, Color.orange);
            } else {
                pane.setForegroundAt(1, defaultForeColor);
                pane.setBackgroundAt(1, defaultBackColor);
            }
            pane.repaint();
        }
    });

    frame.add(pane);
    frame.setVisible(true);