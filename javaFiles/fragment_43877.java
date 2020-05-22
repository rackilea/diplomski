import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleGroceryList extends JPanel {
    private static final int JLIST_VISIBLE_ROWS = 25;
    private JTextField itemField = new JTextField(10);
    private JSpinner itemNumberSpinner = new JSpinner(new SpinnerNumberModel(1, 0, 10, 1));
    private JButton addItemButton = new JButton(new AddItemAction(this, "Add Item", KeyEvent.VK_A));
    private JPanel itemPanel = new JPanel();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> itemJList = new JList<>(listModel);

    public SimpleGroceryList() {
        JPanel addItemPanel = new JPanel();
        addItemPanel.add(new JLabel("Item:"));
        addItemPanel.add(itemField);
        addItemPanel.add(new JLabel("Count:"));
        addItemPanel.add(itemNumberSpinner);
        addItemPanel.add(addItemButton);

        // give jpanel a border and a decent layout that will accept jlabels well
        itemPanel.setBorder(BorderFactory.createTitledBorder("Item Panel"));
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.PAGE_AXIS));

        // make the JList large
        itemJList.setVisibleRowCount(JLIST_VISIBLE_ROWS);

        setLayout(new GridLayout(1, 0));
        add(addItemPanel);
        add(new JScrollPane(itemPanel));
        add(new JScrollPane(itemJList));
    }

    // public methods that our Action can use
    public String getNewItemText() {
        return itemField.getText();
    }

    public int getNewItemCount() {
        return (int) itemNumberSpinner.getValue();
    }

    public void addNewItem(String newItem) {
        // add to jpanel
        itemPanel.add(new JLabel(newItem));
        itemPanel.revalidate();
        itemPanel.repaint();

        // add to jlist
        listModel.addElement(newItem);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }

    private static void createAndShowGui() {
        SimpleGroceryList mainPanel = new SimpleGroceryList();
        JFrame frame = new JFrame("SimpleGroceryList");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

@SuppressWarnings("serial")
class AddItemAction extends AbstractAction {
    private SimpleGroceryList simpleGroceryList;

    // pass the GUI into this class
    public AddItemAction(SimpleGroceryList simpleGroceryList, String name, int mnemonic) {
        super(name);  // the button's text
        putValue(MNEMONIC_KEY, mnemonic);  // the button's alt-key hot-key
        this.simpleGroceryList = simpleGroceryList; // set a field with the parameter
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // create our new item string
        String item = simpleGroceryList.getNewItemText();
        int count = simpleGroceryList.getNewItemCount();
        String newItem = item + ": " + count;

        // and pass it into gui
        simpleGroceryList.addNewItem(newItem);
    }
}