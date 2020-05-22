import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;    
import javax.swing.*;

@SuppressWarnings("serial")
public class TestDragging extends JPanel {
    private static final String[] ITEMS = {"Item One", "Item Two", "Item Three"};
    private static final Dimension PREF_SIZE = new Dimension(400, 400);
    private JLabel label;
    private JComboBox<String> comboBox = new JComboBox<>(ITEMS);
    private JLayeredPane layeredPane = new JLayeredPane();

    public TestDragging() {
        comboBox.addActionListener(new ComboListener());
        JPanel topPanel = new JPanel();
        topPanel.add(comboBox);

        layeredPane.setPreferredSize(PREF_SIZE);
        layeredPane.setBorder(BorderFactory.createEtchedBorder());

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(layeredPane, BorderLayout.CENTER);
    }

    private class ComboListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (label != null) {
                layeredPane.remove(label);
            }

            int index = comboBox.getSelectedIndex();
            int x = 100;
            int y = 100 + 100 * index;
            String text = comboBox.getSelectedItem().toString();
            label = createDraggingLabel(x, y, text);

            layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);
            layeredPane.repaint();
        }

        private JLabel createDraggingLabel(int x, int y, String text) {
            JLabel label = new JLabel(text);
            label.setSize(label.getPreferredSize());
            label.setLocation(x, y);

            MyMouse myMouse = new MyMouse();
            label.addMouseListener(myMouse);
            label.addMouseMotionListener(myMouse);
            return label;
        }
    }

    private static void createAndShowGui() {
        TestDragging mainPanel = new TestDragging();

        JFrame frame = new JFrame("Test Dragging");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}