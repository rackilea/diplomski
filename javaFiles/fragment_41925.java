import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class NoPrintScreen extends JFrame{

    public final String RED_PAGE = "red page";
    public final String WHITE_PAGE = "white page";
    private CardLayout cLayout;
    private JPanel mainPane;
    boolean isRedPaneVisible = false;

    public NoPrintScreen(){

        setTitle("No Print Screen");
        setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(new MyKeyListener());
        setFocusable(true);

        mainPane = new JPanel();
        cLayout = new CardLayout();
        mainPane.setLayout(cLayout);

        JPanel whitePane = new JPanel();
        whitePane.setBackground(Color.WHITE);
        whitePane.add(new JLabel("Hit Prtint Screen and check resuts"));

        JPanel redPane = new JPanel();
        redPane.setBackground(Color.RED);
        redPane.add(new JLabel("Print Screen is discouraged"));

        mainPane.add(WHITE_PAGE, whitePane);
        mainPane.add(RED_PAGE, redPane);
        add(mainPane,BorderLayout.CENTER);
        switchPanes();
        setVisible(true);
    }

    void switchPanes() {

        if (isRedPaneVisible) {showRedPane();}
        else { showWhitePane();}
    }

    void showWhitePane() {
        cLayout.show(mainPane, WHITE_PAGE);
        isRedPaneVisible = true;
    }

    void showRedPane() {
        cLayout.show(mainPane, RED_PAGE);
        isRedPaneVisible = false;
    }

    public static void main(String[] args) {
        new NoPrintScreen();
    }

    class MyKeyListener extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            if(KeyEvent.VK_PRINTSCREEN== e.getKeyCode()) {

                switchPanes();

                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {

                        try {

                            final Robot robot = new Robot(); //invoke new print screen
                            robot.keyPress(KeyEvent.VK_PRINTSCREEN);

                        } catch (AWTException  ex) { ex.printStackTrace();  }
                    }
                });

            }
        }
    }
}