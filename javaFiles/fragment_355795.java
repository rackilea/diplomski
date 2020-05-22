JButton button = new JButton("Text");

    JPanel panel1 = new JPanel() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
    };
    panel1.add(button);