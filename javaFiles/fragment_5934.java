public class test1 extends javax.swing.JFrame {
    public test1() {
        initComponents();
        jSlider1.setMaximum(255);
        jSlider1.setValue(-255);
}
@SuppressWarnings("unchecked")                     
private void initComponents() {

    jSlider1 = new javax.swing.JSlider();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

}                    

public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new test().setVisible(true);
        }
    });
}

private javax.swing.JSlider jSlider1;                
}