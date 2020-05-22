import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;

public class Test extends JFrame {

    public static final double GOLDEN_RATIO = 1.6180339887498948482;
    public static final double RELATIVE_LENGTH_OF_LONGER_SIDE = 1 / GOLDEN_RATIO;
    public static final double RELATIVE_LENGTH_OF_SHORTER_SIDE = 1 - (1 / GOLDEN_RATIO);
    private static final int screenHeight = 500;
    private static final int LENGTH_OF_LONGER_SIDE_FOR_RATIO = (int) (screenHeight * RELATIVE_LENGTH_OF_LONGER_SIDE);
    private static final int LENGTH_OF_SHORTER_SIDE_FOR_RATIO = (int) (screenHeight * RELATIVE_LENGTH_OF_SHORTER_SIDE);
    private static final int MIN_LENGTH_OF_LONGER_SIDE_FOR_RATIO = (int) (50 * RELATIVE_LENGTH_OF_LONGER_SIDE);
    private static final int MIN_LENGTH_OF_SHORTER_SIDE_FOR_RATIO = (int) (50 * RELATIVE_LENGTH_OF_SHORTER_SIDE);

    public Test() {
        buildGUI();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void buildGUI() {
        JPanel pane = new JPanel();
        // make GridBagLayout
        GroupLayout layout = new GroupLayout(pane);
        pane.setLayout(layout);

        // Make 4 components to put in the four grid spaces.
        JButton filler1 = new JButton("Press here to swap");
        JButton filler2 = new JButton("Press here to swap");
        JButton filler3 = new JButton("Press here to swap");
        Object[] objects = new Object[50];
        for (int i = 0; i < 50; i++) {
            objects[i] = "Test" + i;
        }
        JTree jTree = new JTree(objects);
        JScrollPane scrollPane = new JScrollPane(jTree);
        JButton button = new JButton("Press here to swap");
        JPanel filler4 = new JPanel(new BorderLayout());
        filler4.add(button);
        ActionListener l = (e) -> {
            if (filler4.getComponents()[0] instanceof JButton) {
                filler4.remove(button);
                filler4.add(scrollPane, BorderLayout.CENTER);
            } else {
                filler4.remove(scrollPane);
                filler4.add(button, BorderLayout.CENTER);
            }
            filler4.repaint();
            filler4.revalidate();
        };
        filler1.addActionListener(l);
        filler2.addActionListener(l);
        filler3.addActionListener(l);
        button.addActionListener(l);
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(filler1, MIN_LENGTH_OF_LONGER_SIDE_FOR_RATIO, LENGTH_OF_LONGER_SIDE_FOR_RATIO, Short.MAX_VALUE)
                        .addComponent(filler2, MIN_LENGTH_OF_LONGER_SIDE_FOR_RATIO, LENGTH_OF_LONGER_SIDE_FOR_RATIO, Short.MAX_VALUE)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(filler3, MIN_LENGTH_OF_SHORTER_SIDE_FOR_RATIO, LENGTH_OF_SHORTER_SIDE_FOR_RATIO, Short.MAX_VALUE)
                        .addComponent(filler4, MIN_LENGTH_OF_SHORTER_SIDE_FOR_RATIO, LENGTH_OF_SHORTER_SIDE_FOR_RATIO, Short.MAX_VALUE)
                ));
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(filler1, MIN_LENGTH_OF_SHORTER_SIDE_FOR_RATIO, LENGTH_OF_SHORTER_SIDE_FOR_RATIO, Short.MAX_VALUE)
                        .addComponent(filler3, MIN_LENGTH_OF_SHORTER_SIDE_FOR_RATIO, LENGTH_OF_SHORTER_SIDE_FOR_RATIO, Short.MAX_VALUE)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(filler2, MIN_LENGTH_OF_LONGER_SIDE_FOR_RATIO, LENGTH_OF_LONGER_SIDE_FOR_RATIO, Short.MAX_VALUE)
                        .addComponent(filler4, MIN_LENGTH_OF_LONGER_SIDE_FOR_RATIO, LENGTH_OF_LONGER_SIDE_FOR_RATIO, Short.MAX_VALUE)
                ));
        add(pane);
        setSize(new Dimension(200, 200));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Test().setVisible(true);
        });
    }

}