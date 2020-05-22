import java.awt.GridLayout;
import javax.swing.*;

class Test {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,0));

        String[] example = new String[] {"one", "two", "three", "four"};

        JComboBox cBox = new JComboBox(example);
        //cBox.setPreferredSize(new Dimension(300, 20));

        panel.add(new JLabel("This is text that goes above the ComboBox:"));
        panel.add(cBox);
        panel.setBorder(BorderFactory.createTitledBorder("Panel border"));

        frame.setContentPane(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}