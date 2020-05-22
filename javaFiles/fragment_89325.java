import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class FruitAndVedg extends JFrame implements ActionListener, ItemListener {

    private static final long serialVersionUID = 4L;
    private JComboBox<String> mainComboBox;
    private JComboBox<String> subComboBox;
    private ArrayList item;
    private Hashtable<Object, Object> subItems = new Hashtable<>();

    public FruitAndVedg() {
        item = new ArrayList();
        item.add("Select Item");
        item.add("Fruit");
        item.add("Vedg");
        String[] items = {"Select Item", "Color", "Shape", "Fruit"};
        mainComboBox = new JComboBox<>(items/*item.toArray()*/);
        mainComboBox.setSelectedItem("Fruit");
        mainComboBox.addActionListener(this);
        mainComboBox.addItemListener(this);
        //mainComboBox.setSelectedItem("Shape");
        add(mainComboBox, BorderLayout.WEST);
        subComboBox = new JComboBox<>();
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX");
        add(subComboBox, BorderLayout.CENTER);
        String[] subItems1 = {"Select Fruit", "Apple", "Plum"};
        subItems.put(items, subItems1);
        String[] subItems2 = {"Select Vedg", "Carrot", "Peas"};
        subItems.put(items, subItems2);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String item = (String) mainComboBox.getSelectedItem();
        Object o = subItems.get(item);
        if (o == null) {
            subComboBox.setModel(new DefaultComboBoxModel());
        } else {
            subComboBox.setModel(new DefaultComboBoxModel((String[]) o));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            if (ie.getSource() == mainComboBox) {
                if (mainComboBox.getSelectedIndex() != 0) {
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new FruitAndVedg();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}