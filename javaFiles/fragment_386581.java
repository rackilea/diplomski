public static void main(String args[]) {
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {

            GameUI cgui = new GameUI();
            cgui.setVisible(true);
        }
    });

}