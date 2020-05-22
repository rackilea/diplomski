public class Test {

    private class WektPanel extends JPanel {

        boolean clear;

        public WektPanel() {
            setBackground(Color.BLUE);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawLines(3, g);
        }

        public void clear() {
            clear = true;
            repaint();
        }

        public void draw() {
            clear = false;
            repaint();
        }

        private void drawLines(int stroke, Graphics g) {
            if (!clear) {
                g.drawLine(0, 0, getWidth(), getHeight());
                g.drawLine(0, getHeight(), getWidth(), 0);
                for (int i = 1; i < stroke; i++) {
                    g.drawLine(0 + i, 0, getWidth(), getHeight() - i);
                    g.drawLine(0, 0 + i, getWidth() - i, getHeight());
                    g.drawLine(0, getHeight() - i, getWidth() - i, 0);
                    g.drawLine(0 + i, getHeight(), getWidth(), 0 + i);
                }
            }
        }
    }

    private void showGUI() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final WektPanel wektPanel = new WektPanel();
        f.add(wektPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new AbstractAction("Clear") {

            @Override
            public void actionPerformed(ActionEvent e) {
                wektPanel.clear();
            }
        }));
        buttonPanel.add(new JButton(new AbstractAction("Draw") {

            @Override
            public void actionPerformed(ActionEvent e) {
                wektPanel.draw();
            }
        }));
        f.add(buttonPanel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().showGUI();
            }
        });
    }
}