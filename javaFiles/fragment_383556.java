public class MyFrame extends javax.swing.JFrame {
    private javax.swing.JMenuItem jMenuItem1;

    public MyFrame() {
        initComponents();
    }

    /* Auto-generated code */
    private void initComponents() {
        jMenuItem1 = new JMenuItem();
        jMenuItem1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
    }

    /* Auto-generated method */
    private jmenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        /* Your hand written code */
        MyDialog dialog = new MyDialog(MyFrame.this, true);
    }

    public static void main(String[] args) {

    }
}