public class Frame extends javax.swing.JFrame{
    // ...

    public void main() {
        // ...        
        Frame ref = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ref.setVisible(true);
            }
        });
    }

    // ...
}