import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TestGrid02  {

    private static final Dimension PREF_SIZE = new Dimension(50, 50);
    private JPanel ui;
    private JPanel gameGrid;

    public TestGrid02() {
        initUI();
    }

    private final void initUI() {
        ui = new JPanel(new BorderLayout(5, 5));
        ui.setBackground(Color.YELLOW);
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));
        createMap(10, 10);
        ui.add(gameGrid);

        JPanel controlsConstrain = new JPanel(new BorderLayout(4, 4));
        ui.add(controlsConstrain, BorderLayout.LINE_END);
        controlsConstrain.setBackground(Color.GREEN);

        JPanel controls = new JPanel(new GridLayout(0, 1, 0, 25));
        controlsConstrain.add(controls, BorderLayout.PAGE_START);
        controls.setBackground(Color.CYAN);
        controls.setBorder(new EmptyBorder(40, 20, 20, 20));
        controls.add(new JTextField(10));
        controls.add(new JTextField(10));
        controls.add(new JButton("OK"));
    }

    public void createMap(int maxX, int maxY) {
        gameGrid = new JPanel(new GridLayout(maxX, maxY, 1, 1));
        gameGrid.setBackground(Color.RED);

        for (int i = 0; i < maxX; i++) {

            for (int j = 0; j < maxY; j++) {
                JPanel panel = new JPanel();
                panel.setPreferredSize(PREF_SIZE);
                String name = String.format("[%d, %d]", i, j);
                panel.setName(name);
                gameGrid.add(panel);
            }
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Astar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TestGrid02().getUi());
        // this was being called at the wrong time, but ..
        // frame.setLocationRelativeTo(null);
        // ..better to..
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);  // should be last.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    public JPanel getUi() {
        return ui;
    }
}