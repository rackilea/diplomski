pnlpnl = new JPanel() {

        @Override
        public void paintComponent(Graphics gr) {
            super.paintComponent(gr);
            gr.setColor(Color.CYAN);
            gr.fillRect(0, 0, 200, 200);
        }
    };