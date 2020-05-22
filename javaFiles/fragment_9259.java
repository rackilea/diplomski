public static void main(String[] args) {
    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.RED);
            g.drawRect(32,32,32,32);
        }
    };

    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame f = new JFrame();
    f.add(panel);
    f.setSize(256,256);

    // The following two statements cause the window-transparency:
    f.setUndecorated(true);
    f.setBackground(new Color(0,255,0,0));

    f.setVisible(true);
}