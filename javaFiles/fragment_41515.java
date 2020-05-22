public class ParentClass extends javax.swing.JFrame {
    private void processC() {
        JFrame controller = new Controller(this);
        this.setVisible(false);
        ...
public class Controller extends javax.swing.JFrame {
    private ParentClass parent;
    public Controller(ParentClass parent) {
        this.parent = parent;
    }
    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        parent.exit(); // or whatever
        System.exit(0);
        ...