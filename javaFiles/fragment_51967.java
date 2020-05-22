import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingResizeJFrame {

    public SwingResizeJFrame() {
        JTextField TextField1 = new JTextField("firstTextField");
        JTextField TextField2 = new JTextField("secondTextField");
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new GridLayout(0, 2, 10, 10));
        firstPanel.add(TextField1);
        firstPanel.add(TextField2);

        JComboBox comboBox1 = new JComboBox(new Object[]{"Ester", "Jordi", "Jordina", "Jorge", "Sergi"});
        JComboBox comboBox2 = new JComboBox(new Object[]{"Ester", "Jordi", "Jordina", "Jorge", "Sergi"});
        JComboBox comboBox3 = new JComboBox(new Object[]{"Ester", "Jordi", "Jordina", "Jorge", "Sergi"});
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new GridLayout(0, 3, 10, 10));
        secondPanel.add(comboBox1);
        secondPanel.add(comboBox2);
        secondPanel.add(comboBox3);

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(firstPanel);
        frame.add(secondPanel);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                SwingResizeJFrame demo = new SwingResizeJFrame();
            }
        });
    }
}