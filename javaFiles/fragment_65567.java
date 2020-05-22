import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

class OnurComboBox extends JDialog implements
        ActionListener, ItemListener {

    private final JPanel contentPanel = new JPanel();
    private JComboBox comboBox = null;
    private int comnum;
    public String combo;
//    final String[] theOptions = {
//  "Option 1", "Option 2", 
//        "Option 3", "Option 4", 
//  "Option 5", "Option 6"
//    };
    private JTextField textField;
    private JTextField textField_1;
    String filePath = "t.txt";
     BufferedReader input = new BufferedReader(new FileReader(filePath));
public static PrintWriter out;

/**
 * Launch the application.
 */
public static void main(String[] args) {
    try {
        out = new PrintWriter(new BufferedWriter(new FileWriter("t.txt", true)));
    } catch (Exception e) {
    }

    try {
        OnurComboBox dialog = new OnurComboBox();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    /**
     * Create the dialog.
     */
    public OnurComboBox() throws FileNotFoundException, IOException {



        setTitle("Choose an Option");
        setSize(325, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JDesktopPane desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane, BorderLayout.CENTER);

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("The item selected is: " + combo);

                out.close();


                System.exit(0);
            }
        });
        btnOk.setBounds(66, 153, 89, 23);
        desktopPane.add(btnOk);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnCancel.setBounds(165, 153, 89, 23);
        desktopPane.add(btnCancel);

//        final JComboBox comboBox = new JComboBox(theOptions);

        List<String> strings = new ArrayList<String>();
        try {
            String line = null;
            while ((line = input.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error, file " + filePath + " didn't exist.");
        } finally {
            input.close();
        }

        String[] lineArray = strings.toArray(new String[]{});
        final DefaultComboBoxModel model = new DefaultComboBoxModel(lineArray);
        final JComboBox comboBox = new JComboBox(model);
        comboBox.setBounds(10, 34, 187, 23);
        comboBox.setSelectedIndex(-1);
        comboBox.addItemListener(this);
        desktopPane.add(comboBox);
        comboBox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent ie) {
                combo = (String) comboBox.getSelectedItem();
                comnum = comboBox.getSelectedIndex();
                textField.setText(combo);
            }
        });

        textField = new JTextField();
        textField.setBounds(10, 228, 187, 23);
        desktopPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(10, 103, 187, 23);
        desktopPane.add(textField_1);
        textField_1.setColumns(10);

        JTextPane txtpnSelected = new JTextPane();
        txtpnSelected.setEditable(false);
        txtpnSelected.setText("Item Selected:");
        txtpnSelected.setBounds(10, 202, 89, 23);
        desktopPane.add(txtpnSelected);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!textField_1.getText().equals("")) {
                    int a = 0;
                    for (int i = 0; i < comboBox.getItemCount(); i++) {
                        if (comboBox.getItemAt(i).equals(textField_1.getText())) {
                            a = 1;
                            break;
                        }
                    }
                    if (a == 1) {
                        JOptionPane.showMessageDialog(null, "Combobox already has this item.");
                    } else {
                        comboBox.addItem(textField_1.getText());
                    }

                    out.println(textField_1.getText());


                    JOptionPane.showMessageDialog(null, "Item added to Combobox");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter text in the Text Box");
                }
            }
        });

        btnAdd.setBounds(207, 103, 92, 23);
        desktopPane.add(btnAdd);

        JTextPane txtpnEnterTheOption = new JTextPane();
        txtpnEnterTheOption.setText("Enter the new option:");
        txtpnEnterTheOption.setEditable(false);
        txtpnEnterTheOption.setBounds(10, 80, 131, 23);
        desktopPane.add(txtpnEnterTheOption);

        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (comboBox.getItemCount() > 0) {
                    comboBox.removeItemAt(comnum);
                    JOptionPane.showMessageDialog(null, "Item removed");
                } else {
                    JOptionPane.showMessageDialog(null, "Item not available");
                }
            }
        });
        btnRemove.setBounds(207, 34, 92, 23);
        desktopPane.add(btnRemove);

        JTextPane txtpnSelectAnItem = new JTextPane();
        txtpnSelectAnItem.setText("Select an item from the list or add a new option");
        txtpnSelectAnItem.setBounds(10, 3, 289, 20);
        desktopPane.add(txtpnSelectAnItem);
        setVisible(true);


    }

    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox combo = (JComboBox) e.getSource();
//            int index = combo.getSelectedIndex();
//            display.setIcon(new ImageIcon(
//                ClassLoader.getSystemResource(images[index])));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}