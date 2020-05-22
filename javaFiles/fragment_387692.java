public class Frame2 extends javax.swing.JFrame {

    Frame1 frame1;
    public Frame2(Frame1 frame1) {
        this.frame1 = frame1;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        frame1 = new Frame1();
        frame1.addTextToComboBox();
    }

}