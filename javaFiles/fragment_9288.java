public class Form1 extends javax.swing.JDialog {
    public Form1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    ...
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        setVisible(false);
    }