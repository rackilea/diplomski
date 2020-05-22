import javax.swing.*;

public class Gui extends JPanel {

    private JComboBox cbo1 = new JComboBox();
    private JComboBox cbo2 = new JComboBox();
    private JComboBox cbo3 = new JComboBox();
    private JComboBox cbo4 = new JComboBox();
    private JComboBox cbo5 = new JComboBox();
    private JButton button = new JButton();

    public Gui() {
        add(cbo1);
        add(cbo2);
        add(cbo3);
        add(cbo4);
        add(cbo5);
        add(button); 
    }
}