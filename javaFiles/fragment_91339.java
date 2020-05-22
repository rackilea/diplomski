package test1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class ComboBoxTwo extends JFrame implements ActionListener, ItemListener {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> mainComboBox;
    private JComboBox<String> subComboBox;

    private JLabel label;
    private String[][] descriptions;

    private Hashtable<Object, Object> subItems = new Hashtable<Object, Object> ();

    public ComboBoxTwo() {
        String[] items = {"Select Item", "Color", "Shape", "Fruit"};
        this.getContentPane().setLayout(null);

        this.setSize(400, 400);

        mainComboBox = new JComboBox<String>(items);
        mainComboBox.addActionListener(this);
        mainComboBox.addItemListener(this);
        mainComboBox.setSize(100, 100);
        mainComboBox.setLocation(0, 100);


        subComboBox = new JComboBox<String>();  
        subComboBox.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
        subComboBox.addItemListener(this);
        subComboBox.setSize(100, 100);
        subComboBox.setLocation(this.getSize().width - 120, 100);


        String[] subItems1 = {"Select Color", "Red", "Blue", "Green"};
        subItems.put(items[1], subItems1);

        String[] subItems2 = {"Select Shape", "Circle", "Square", "Triangle"};
        subItems.put(items[2], subItems2);

        String[] subItems3 = {"Select Fruit", "Apple", "Orange", "Banana"};
        subItems.put(items[3], subItems3);


        label = new JLabel();
        label.setSize(300, 25);
        label.setLocation(this.getSize().width /2 - label.getSize().width /2, 25);
        label.setText("This is a label: currently nothing selected");
        label.setVisible(true);


        getContentPane().add(subComboBox);
        getContentPane().add(mainComboBox);
        getContentPane().add(label);

        descriptions = new String[][]
        { 
            {"The red color", "The blue color", "A green color"}, 
            {"This shape is round", "Looks rectangular", "Has three sides"}, 
            {"Didn't fall far from the tree", "Seems quite orangy", "Look i've got a banana in my trousers"} 
        };    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String item = (String) mainComboBox.getSelectedItem();
        Object o = subItems.get(item);
        if (o == null) {
            subComboBox.setModel(new DefaultComboBoxModel<String>());
        } else {
            subComboBox.setModel(new DefaultComboBoxModel<String>((String[]) o));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {

            if (mainComboBox.getSelectedIndex() == 0 && subComboBox.getSelectedIndex() == 0)
            {
                label.setText("This is a label: currently nothing selected");
            }
            else if (mainComboBox.getSelectedIndex() >= 0)
            {
                label.setText("The first combobox has been altered");
            }

            if (e.getSource() == mainComboBox) {
                if (mainComboBox.getSelectedIndex() != 0) {
                    FirstDialog firstDialog = new FirstDialog(ComboBoxTwo.this,
                            mainComboBox.getSelectedItem().toString(), "Please wait,  Searching for ..... ");
                }
            }
            else if (e.getSource() == subComboBox)
            {
                label.setText(descriptions[mainComboBox.getSelectedIndex() -1][((JComboBox<String>) e.getSource()).getSelectedIndex() -1]);
            }
        }
    }

    private class FirstDialog extends JDialog {

        private static final long serialVersionUID = 1L;

        FirstDialog(final Frame parent, String winTitle, String msgString) {
            super(parent, winTitle);
            setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            JLabel myLabel = new JLabel(msgString);
            JButton bNext = new JButton("Stop Processes");
            add(myLabel, BorderLayout.CENTER);
            add(bNext, BorderLayout.SOUTH);
            bNext.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    setVisible(false);
                }
            });
            javax.swing.Timer t = new javax.swing.Timer(1000, new  ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });
            t.setRepeats(false);
            t.start();
            setLocationRelativeTo(parent);
            setSize(new Dimension(400, 100));
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new ComboBoxTwo();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}