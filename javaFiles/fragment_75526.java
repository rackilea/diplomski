public static void Subtraction() {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                Subtraction window = new Subtraction();
                window.frmSubtraction.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}