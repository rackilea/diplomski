public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {

                gui = new GUIClass();
                gui.getFrame().setVisible(true);
                new MainClass();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}