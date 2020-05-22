public class Main {

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frame2 frame2 = new Frame2();
                Frame1 frame1 = new Frame1();

                // Register frame2 as an observer of frame1
                frame1.addObserver(frame2);

                frame1.setVisible(true);
                frame2.setVisible(true);
            }
        });
    }

}