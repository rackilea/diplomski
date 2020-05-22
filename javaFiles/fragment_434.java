public static void main(String[] args)  throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new JFrame("frame1").setVisible(true);
            new JFrame("frame2").setVisible(true);
        }
    });
}