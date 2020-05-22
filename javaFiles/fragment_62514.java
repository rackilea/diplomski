import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class test {

    public static void main(String[] args) {

        final JDialog frame = new JDialog(new JFrame());
        frame.setSize(320, 240);
        frame.setContentPane(new JLabel(new ImageIcon("H:\\walk.gif")));
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        new Thread(new Runnable() {

            @Override
            public void run() {
                sleepThread();
                CloseDialog(frame);
                System.exit(0);
            }
        }).start();

        ShowDialog(frame);

    }

    private static void sleepThread() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            // Do something, if there is a exception
            System.out.println(ex.toString());
        }
    }

    private static void ShowDialog(final JDialog dialog) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                dialog.setVisible(true);
            }
        });
    }

    private static void CloseDialog(final JDialog dialog) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                dialog.setVisible(false);
            }
        });
    }
}