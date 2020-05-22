import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITest implements ActionListener {
    private JFrame frmInventorysystem;
    private JPanel frameBottom;
    private JComboBox equipList;
    private JButton confirmBtn, cancelBtn;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUITest()); //Java 8+ if using an earlier version check the point #2 in this answer and modify the code accordingly.
    }

    /**
     * Create the application.
     */
    public GUITest() {
        frmInventorysystem = new JFrame();
        frmInventorysystem.setTitle("InventorySystem");
        frmInventorysystem.setBounds(100, 100, 450, 300);
        frmInventorysystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmInventorysystem.getContentPane().setLayout(new BorderLayout(0, 0));

        /*
         * JFrame inside another JFrame is not recommended. JPanels are used instead
         * Creating a flow layout for the bottom frame
         */
        frameBottom = new JPanel();
        frameBottom.setLayout(new FlowLayout());

        // creates comboBox to find out which of the three items player is looking to
        // insert
        String[] weaponCategories = { "Weapon", "Armor", "Mod" };
        equipList = new JComboBox(weaponCategories);
        frmInventorysystem.getContentPane().add(equipList, BorderLayout.NORTH);

        // Converting BorderLayout.south into a flow layout
        frmInventorysystem.getContentPane().add(frameBottom, BorderLayout.SOUTH);

        confirmBtn = new JButton("Confirm");
        confirmBtn.addActionListener(this);

        frameBottom.add(confirmBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(this);
        frameBottom.add(cancelBtn);

        frmInventorysystem.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // creates new windows to sort equipment when confirmBtn is clicked
        if (e.getSource() == confirmBtn) {
            String category = equipList.getSelectedItem().toString(); //Get the selected category
            doSomething(category); //Pass it as a parameter
        }
        // Exits when cancelBtn is clicked
        if (e.getSource() == cancelBtn) {
            frmInventorysystem.dispose();
        }
    }

    // Do something with the category
    private void doSomething(String selectedEquipment) {
        System.out.println(selectedEquipment);
        if (selectedEquipment.equals("Weapon")) {
            System.out.println("It's a weapon!"); //You can open dialogs or do whatever you need here, not necessarily a print.
        } else {
            System.out.println("Not a weapon");
        }
    }
}