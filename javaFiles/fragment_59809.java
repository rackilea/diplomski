JButton left = new JButton("move left");
        add(left, BorderLayout.WEST);
        left.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        X = X - 20;
                        dude.x = X;
                        dude.y = Y;
                        repaint();
                    }
                });
        JButton right = new JButton("move right");
        add(right, BorderLayout.EAST);
        right.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        X = X + 20;
                        dude.x = X;
                        dude.y = Y;
                        repaint();
                    }
                });
        JButton up = new JButton("move up");
        add(up, BorderLayout.NORTH);
        up.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        Y = Y - 20;
                        dude.x = X;
                        dude.y = Y;
                        repaint();

                    }
                });
        JButton down = new JButton("move down");
        add(down, BorderLayout.SOUTH);
        down.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        Y = Y + 20;
                        dude.x = X;
                        dude.y = Y;
                        repaint();
                    }
                });