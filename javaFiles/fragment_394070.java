JTable table = new JTable(12, 6) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(new GraphicsWorkaround(g));
        }
    };