public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            MyFrame frame = new MyFrame();
            MyPanel panel = new MyPanel();
            frame.add(panel);
            panel.setFocusable(true);
            frame.invalidate();
            frame.validate();
            frame.repaint();
        }
    });
}