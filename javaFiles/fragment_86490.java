void uiFunction() {
    new Thread() {
        public void run() {
            for(int i = 0; i < 10; i++) {
                final JButton b = buttons[i];
                SwingUtilities.invokeLater(new Runnable() {
                    b.setBackground(Color.WHITE);
                    b.repaint();
                }
                Thread.sleep(2000);
                SwingUtilities.invokeLater(new Runnable() {
                    b.setBackground(Color.GRAY);
                    b.repaint();
                }
            }
        }
    }.run();
}