public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
                LoginForm login = new LoginForm();
                login.setVisible(true);
        }
  });
}