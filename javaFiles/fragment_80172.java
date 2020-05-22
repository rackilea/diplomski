import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MigLayoutTest extends JPanel
{
    private MigLayoutTest(boolean addExtraRow1, boolean addExtraRow2)
    {
        JFrame frame = new JFrame("MigLayout Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new JScrollPane(getPage(addExtraRow1, addExtraRow2)));
        frame.getContentPane().setMinimumSize(new Dimension(650, 336));
        frame.getContentPane().setPreferredSize(new Dimension(890, 562));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel getPage(boolean addExtraRow1, boolean addExtraRow2)
    {
        // Create buttons panel
        JPanel listButtonPanel = new JPanel(new MigLayout("ins 0, wrap 1, aligny top"));
        JButton addBtn = new JButton("Add");
        listButtonPanel.add(addBtn, "w 105px, h 25px, sg btns");

        JButton removeBtn = new JButton("Remove");
        listButtonPanel.add(removeBtn, "sg btns");

        JButton copyBtn = new JButton("Copy");
        listButtonPanel.add(copyBtn, "sg btns");

        // Create other components
        int rowCount = 1; // make a dummy row at the bottom to push all the components beside the button panel up

        JTextField txtField = new JTextField();
        rowCount++;

        JComboBox comboBox = new JComboBox(new String[] {"cbx itm 1", "cbx itm 2", "cbx itm 3"});
        comboBox.setEditable(true);
        comboBox.setSelectedItem("");
        rowCount++;

        JCheckBox checkBox = null;
        if (addExtraRow1)
        {
            checkBox = new JCheckBox();
            rowCount++;

        }

        JTextField optTxtField = null;
        if (addExtraRow2)
        {
            optTxtField = new JTextField();
            rowCount++;
        }

        rowCount++;

        JList list = new JList(new DefaultListModel());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(-1);
        String[] names = new String[] {"Stuff to", "fill this", "JList..."};
        DefaultListModel model = (DefaultListModel)list.getModel();
        for (String name : names)
            model.addElement(name);

        JTextArea textArea = new JTextArea();

        // Generate row constraints
        StringBuilder rowConstraints = new StringBuilder();
        for (int i=0; i<rowCount; i++)
            rowConstraints.append("[]");
        rowConstraints.append("[grow, fill]");

        // Create main panel and add components
        JPanel panel = new JPanel(new MigLayout("fill, wrap 3, debug", "[][][grow, fill, align left]", rowConstraints.toString()));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(listButtonPanel, "spany " + --rowCount + ", aligny top, hmax 100%"); // decrement rowCount because the buttons should be above the bottom components' labels

        addComponent(panel, new JLabel("Property 1"), txtField);
        addComponent(panel, new JLabel("ComboBox Property"), comboBox);
        if (checkBox != null)
            addComponent(panel, new JLabel("Extra comp 1"), checkBox);
        if (optTxtField != null)
            addComponent(panel, new JLabel("Extra comp 2"), optTxtField);

        panel.add(new JLabel("A big JList"), "skip 3, spanx 2, grow"); // skip the dummy row before adding this
        panel.add(new JLabel("A big JTextArea"));

        panel.add(new JScrollPane(list), "hmin 100px, spanx 2, grow");
        panel.add(new JScrollPane(textArea), "hmin 100px, grow");

        return panel;
    }

    private void addComponent(JPanel panel, JLabel label, Component component)
    {
        label.setLabelFor(component);
        panel.add(label, "align right");
        panel.add(component);
    }

    public static void main(final String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { new MigLayoutTest(args.length > 1, args.length == 2); }
        });
    }
}