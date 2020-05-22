// The main method (entry point).
public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            showGUI();
            counter.start();
        }
    });
}