public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
        public void run(){
            LoginWindow loginframe = new LoginWindow();
            loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginframe.initialize();
            loginframe.setVisible(true);
        }
    });
}