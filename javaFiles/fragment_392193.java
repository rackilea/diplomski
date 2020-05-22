/* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new DisplayFile().setText(new File("exam")).setVisible(true);
        }
    });
}