import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * link: http://stackoverflow.com/a/41418250/522444
 * 
 * @author Pete
 *
 */
@SuppressWarnings("serial")
public class Main2 extends JPanel {
    private View mainPanel;

    public Main2(MatrixModel matrixModel) {
        mainPanel = new View(matrixModel);
        new Controller(matrixModel, mainPanel);

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }

    private static void createAndShowGui(MatrixModel model) {
        Main2 mainPanel = new Main2(model);

        JFrame frame = new JFrame("Main2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final MatrixModel model = MatrixUtil.getInput(MatrixUtil.PATH_TO_RSC);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui(model);
            }
        });
    }
}