public class Frame extends javax.swing.JFrame{
    // ...

    public void main() {
        // ...        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // ...
}