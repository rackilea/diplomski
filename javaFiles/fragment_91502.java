package snippet;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BorderLayoutTest extends JFrame {

    static private int MAX = 10 ;

    public BorderLayoutTest() {
        super(BorderLayoutTest.class.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(0, 2));
        for(int i = 0; i < MAX; i++) {
            add(createComboPanel());
            add(createPanelWithTextFields());
        }
        pack();
    }

    public Component createComboPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JComboBox<>(new String[] { "First Option", "Second Option", "Third Option" }), BorderLayout.NORTH);
        return panel;
    }

    private Component createPanelWithTextFields() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JTextField(30));
        panel.add(new JTextField(30));
        panel.add(new JTextField(30));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
                new BorderLayoutTest().setVisible(true);
            }
        });
    }

}