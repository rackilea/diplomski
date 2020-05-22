import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Scanner;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Main extends JFrame {

    private static final long serialVersionUID = 7225065896901900132L;

    /**
     * Aye, I do not recommend storing passwords as plain text if it is for
     * something important but here is this code anyway because i'm bored.
     *
     * Also should not that using a AutoHotKey or any other macro program is way
     * easier but im using Java because learning amiright
     */
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main frame = new Main();
                frame.setTitle("Copier");
                frame.setResizable(false);
                frame.setSize(100, 100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                        // try catch for forcing Escape key press
                        try {
                            Robot robObject = new Robot();
                            robObject.keyPress(KeyEvent.VK_ESCAPE);
                            robObject.keyRelease(KeyEvent.VK_ESCAPE);
                            System.out.println("press");
                        } catch (AWTException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                    }
                });
                t.start();
            }
        });
    }

    public Main() {
        JPanel panel = new JPanel(new BorderLayout());
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");
        actionMap.put("escape", new EscapeAction());

        setContentPane(panel);
    }

    protected class EscapeAction extends AbstractAction {

        private final String fileName = "C:/users/21cra/Desktop/rmtinfo.txt";

        @Override
        public void actionPerformed(ActionEvent e) {
            String pass = null;
            File passFile = new File(fileName);
            try (Scanner scanner = new Scanner(new File(fileName))) {
                pass = scanner.next();

                StringSelection stringObj = new StringSelection(pass);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringObj, null);
                System.exit(0);

                System.out.println(pass);

            } catch (Exception error) {

                System.out.println("Error " + error);

            }
        }

    }

}