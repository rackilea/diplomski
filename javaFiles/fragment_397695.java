public class Controller extends javax.swing.JFrame
{   
    public void updateProgressBar(int i) {
        jProgressBar1.setValue(i);
        // no need for repaint. The progress bar knows it must be repainted 
        // when its value changes
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Controller app = new Controller();
                app.setVisible(true);
                app.setResizable(false);
            }
        });
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        ChildModel model = new ChildModel(this);
        Thread t1 = new Thread(model);
        t1.start();
    }

    private javax.swing.JProgressBar jProgressBar1; //Initialized with Netbeans builder
}

public class ChildModel implements Runnable
{

    private Controller controller;

    public ChildModel(Controller controller){
        this.controller = controller;
    }

    public void complexMath()
    {
        //Lots of logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controller.updateProgression(percent);
            }
        });
    }

    @Override
    public void run() {
        complexMath();
    }
}