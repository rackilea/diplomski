public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                ScoreWindow window = new ScoreWindow();
                window.frmScorewindow.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }