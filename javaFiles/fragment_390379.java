import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class SomeClass extends JFrame implements ActionListener {

    private Set<String> attributes = new HashSet<>();
    private String[] values = { "a", "b", "c", "d" };
    private JComboBox<String> menu = new JComboBox<>(values);

    public SomeClass() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new SomeClass();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // attributes.add();
        if (e.getSource() instanceof JComboBox<?>) {
            JComboBox<?> menu = (JComboBox<?>) e.getSource();
            String s = (String) menu.getSelectedItem();
            attributes.removeAll(Arrays.asList(values));
            attributes.add(s);
            System.out.println(s);
            System.out.println(attributes);
        }
    }

    private void init() {
        menu.addActionListener(this);
        add(menu);
    }

}