import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * @see https://stackoverflow.com/questions/8336161
 * @see https://stackoverflow.com/questions/6163606
 */
public class DialogEventTest extends JDialog {

    public DialogEventTest() {
        this.setLayout(new GridLayout(0, 1));
        this.add(new JLabel("Dialog event test.", JLabel.CENTER));
        this.add(new JButton(new AbstractAction("Close") {

            @Override
            public void actionPerformed(ActionEvent e) {
                DialogEventTest.this.setVisible(false);
                DialogEventTest.this.dispatchEvent(new WindowEvent(
                    DialogEventTest.this, WindowEvent.WINDOW_CLOSING));
            }
        }));
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(e.paramString());
            }
        });
    }

    private void display() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DialogEventTest().display();
            }
        });
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Starting…");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println((i + 1) + "s. elapsed.");
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.err);
                    }
                }
                System.out.println("Finished.");
            }
        }).start();
    }
}