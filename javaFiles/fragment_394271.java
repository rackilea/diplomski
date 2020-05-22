public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            Paint paint = new Paint();
            paint.setJMenuBar(initializeMenu());        
            paint.setLayout(new FlowLayout());
            paint.setSize(800, 500);
            paint.setVisible(true);
        }
    });
}