public class AppWin extends javax.swing.JFrame {
    private Form1 form1;
    private Form1 form2;
    ...
    private FormN formN;

    public AppWin() {
        initComponents();
        form1 = new Form1(this, true);
        form2 = new Form2(this, true);
        ...
        formN = new FormN(this, true);
    }
    ...
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        form1.setVisible(true);
    }