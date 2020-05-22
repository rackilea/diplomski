package soapp;

/*
 * File: CalculateBill.java
 * ------------------------
 * This program calculates a table's bill at a restaurant.
 * The program uses a frame user interface with the following components:
 * input textfields for the waiter name and table number
 * four interactive combo boxes for each category of the menu containing all the menu items
 * a listbox that keeps track of menu item that is ordered
 * buttons that allow the user to delete an item or clear all the items on the listbox
 * a textarea that displays the table and waiter name entered
 * a label that refreshes the total, subtotal, and tax when an item is entered or deleted
 * a restaurant logo for "Charlotte's Apple tree restaurant"
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/* CalculateBill.java uses these additional files:
 * images/appletree.gif
 */
/**
 *
 * @version     1.7
 * @since       2011-11-21
 */
@SuppressWarnings("serial")
public class CalculateBill extends JPanel implements ActionListener {

    JComboBox beverageList;
    JComboBox appetizerList;
    JComboBox dessertList;
    JComboBox maincourseList;
    JLabel restaurantLogo;
    JTextField textTableNum;  //where the table number is entered
    JTextField waiterName; //where the waiter name is entered
    JTextArea textArea;//where the waiter name and table number appears at the bottem
    JLabel waiter;
    JLabel table;
    DefaultListModel model;//model
    JList list; // list
    static int tableNum = 0; // setting table number to an integer outside the range (1-10) keeps loop going until
    // valid user entry in textTableNum textfield
    String tn; //string value of table number
    String wn; //string value of waiter name
    JScrollPane scrollpane;
    public double subtotal = 0.00;
    public double tax = 0.00;
    public double total = 0.00;
    JLabel totallabel;

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("SO App");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalculateBill cb = new CalculateBill();
        frame.getContentPane().add(cb);
        frame.pack();
        frame.setVisible(true);
    }

    CalculateBill() {
        super(new BorderLayout());
        JPanel panel;
        //create and set up the window.
//        JFrame frame = new JFrame("Charlotte's Appletree Restaurant");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setPreferredSize(new Dimension(300, 600));

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        String[] beverages = {"Beverages", "Soda", "Tea", "Coffee", "Mineral Water", "Juice", "Milk"};
        String[] appetizers = {"Appetizers", "Buffalo Wings", "Buffalo Fingers", "Potato Skins", "Nachos", "Mushroom Caps", "Shrimp Cocktail", "Chips and Salsa"};
        String[] maincourses = {"Main Courses", "Seafood Alfredo", "Chicken Alfredo", "Chicken Picatta", "Turkey Club", "Lobster Pie", "Prime Rib", "Shrimp Scampi", "Turkey Dinner", "Stuffed Chicken"};
        String[] desserts = {"Desserts", "Apple Pie", "Sundae", "Carrot Cake", "Mud Pie", "Apple Crisp"};

        /*create the combo boxes, selecting the first item at index 0.
        indices start at 0, so so 0 is the name of the combo box*/

        // beverages combobox
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        beverageList = new JComboBox(beverages);
        beverageList.setEditable(false);
        beverageList.setSelectedIndex(0);
        panel.add(new JLabel("  Beverages:"), BorderLayout.CENTER);
        panel.add(beverageList, BorderLayout.CENTER);
        add(panel);
        // appetizers combobox
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        appetizerList = new JComboBox(appetizers);
        appetizerList.setEditable(false);
        appetizerList.setSelectedIndex(0);
        panel.add(new JLabel("  Appetizers:"), BorderLayout.CENTER);
        panel.add(appetizerList, BorderLayout.CENTER);

        // maincourses combobox
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        maincourseList = new JComboBox(maincourses);
        maincourseList.setEditable(false);
        maincourseList.setSelectedIndex(0);
        panel.add(new JLabel(" Main courses:"), BorderLayout.CENTER);
        panel.add(maincourseList, BorderLayout.CENTER);
        add(panel);
        // desserts combox
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

        dessertList = new JComboBox(desserts);
        dessertList.setEditable(false);
        dessertList.setSelectedIndex(0);
        panel.add(new JLabel("  Desserts:"), BorderLayout.CENTER);
        panel.add(dessertList, BorderLayout.CENTER);
        add(panel);
        // listbox
        model = new DefaultListModel();
        JPanel listPanel = new JPanel();
        list = new JList(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));



        // list box continued
        JScrollPane listPane = new JScrollPane();
        listPane.getViewport().add(list);
        listPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        listPanel.add(listPane);
        add(listPanel);

        // total label
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        totallabel = new JLabel(setTotalLabelAmount());
        panel.add((totallabel), BorderLayout.SOUTH);
        totallabel.setVisible(false);
        add(panel);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        // sets up listbox buttons
        panel.add(new JButton("Delete"), BorderLayout.SOUTH);
        panel.add(new JButton("Clear All"), BorderLayout.SOUTH);
        add(panel);

        // sets up restaurant logo
//        restaurantLogo = new JLabel();
//        restaurantLogo.setFont(restaurantLogo.getFont().deriveFont(Font.ITALIC));
//        restaurantLogo.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
//       restaurantLogo.setPreferredSize(new Dimension(123, 200 + 10));
//        ImageIcon icon = createImageIcon("images/appletree.gif");
//        restaurantLogo.setIcon(icon);
//        restaurantLogo.setText("Charlotte's Apple Tree Restaurant");
//        add((restaurantLogo), BorderLayout.NORTH);

        // sets up the label next to textfield for table number

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        table = new JLabel("     Enter Table Number (1-10):");


        /**
         * @throws InputMismatchException if the textfield entry is not an integer
         *
         */
        // sets up textfield next to table lable
        textTableNum = new JTextField();
        table.setLabelFor(textTableNum);
        panel.add((table), BorderLayout.NORTH);
        panel.add(textTableNum, BorderLayout.NORTH);
        add(panel);

        // sets up label for waiter name
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        waiter = new JLabel("      Enter Waiter Name: ");
        waiterName = new JTextField();
        // sets up textfield next to waiter lable
        waiter.setLabelFor(waiterName);
        panel.add((waiter), BorderLayout.NORTH);
        panel.add(waiterName, BorderLayout.NORTH);
        add(panel);

        // listens to the textfields
        textTableNum.addActionListener(this);
        waiterName.addActionListener(this);


        // sets up textarea
        textArea = new JTextArea(5, 10);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);


        // lays out listpanel
//        listPanel.setLayout(new GridBagLayout());

//        GridBagConstraints c = new GridBagConstraints();

//        c.gridwidth = GridBagConstraints.REMAINDER;

//        c.fill = GridBagConstraints.HORIZONTAL;
//        add(listPane, c);
//        add(listPane, null);

//        c.fill = GridBagConstraints.BOTH;

//        c.weightx = 1.0;

//        c.weighty = 1.0;

//        add(scrollPane, c);
        add(scrollPane, null);

        scrollPane.setVisible(true);


    }

    private double getPrices(String item) {
        // create hashmap to store menu items with their corresponding prices

        HashMap<String, Double> hm = new HashMap<String, Double>();

        // put elements to the map
        hm.put("Soda", new Double(1.95));
        hm.put("Tea", new Double(1.50));
        hm.put("Coffee", new Double(1.25));
        hm.put("Mineral Water", new Double(2.95));
        hm.put("Juice", new Double(2.50));
        hm.put("Milk", new Double(1.50));
        hm.put("Buffalo Wings", new Double(5.95));
        hm.put("Buffalo Fingers", new Double(6.95));
        hm.put("Potato Skins", new Double(8.95));
        hm.put("Nachos", new Double(8.95));
        hm.put("Mushroom Caps", new Double(10.95));
        hm.put("Shrimp Cocktail", new Double(12.95));
        hm.put("Chips and Salsa", new Double(6.95));
        hm.put("Seafood Alfredo", new Double(15.95));
        hm.put("Chicken Alfredo", new Double(13.95));
        hm.put("Chicken Picatta", new Double(13.95));
        hm.put("Turkey Club", new Double(11.95));
        hm.put("Lobster Pie", new Double(19.95));
        hm.put("Prime Rib", new Double(20.95));
        hm.put("Shrimp Scampi", new Double(18.95));
        hm.put("Turkey Dinner", new Double(13.95));
        hm.put("Stuffed Chicken", new Double(14.95));
        hm.put("Apple Pie", new Double(5.95));
        hm.put("Sundae", new Double(3.95));
        hm.put("Carrot Cake", new Double(5.95));
        hm.put("Mud Pie", new Double(4.95));
        hm.put("Apple Crisp", new Double(5.95));

        double price = hm.get(item);
        return price;
    }

    /**
     * validates that the correct path for the image was found to prevent crash
     *
     * @param path is the icon path of the restaurant logo
     *
     * @return nothing if you can't find the image file
     *
     * @return imageIcon(imgURL) the path to image if you can find it
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = CalculateBill.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            JOptionPane.showMessageDialog(null, "Couldn't find file: " + path, "image path error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    //Listens to the combo boxes
    private void getSelectedMenuItem(JComboBox cb) {
        String mnItem = (String) cb.getSelectedItem();
        updateListBox(mnItem);

    }

    /**
     * updates the list box
     *
     * @param name the element to be added to the list box
     */
    private void updateListBox(String name) {
        totallabel.setVisible(false);
        model.addElement(name);
        Addition(getPrices(name));
        totallabel.setVisible(true);
    }

    void showWaiterAndTableNum() {
        textArea.append("Table Number: " + tn + " Waiter: " + wn);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    /**
     * adds to the subtotal/total calculator.
     *
     * @param s The name of the menu item which will be used to access its hashmap key value.
     *
     */
    private void Addition(double addedP) {

        subtotal = subtotal + addedP;

        tax = .0625 * subtotal;

        total = subtotal + tax;



    }

    /**
     * subtracts from to the subtotal/total calculator.
     *
     * @param subtractedp The price of the menu item which will be used to access its hashmap key value.
     *
     */
    // sets up the 'total' label which shows subtotal, tax, total
    private void Subtraction(double subtractedp) {

        subtotal = subtotal - subtractedp;

        tax = subtotal * .0625;
        total = subtotal + tax;



    }

    private void resetCalculator() {
        subtotal = 0.00;
        tax = 0.00;
        total = 0.00;



    }

    // listens to list buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField tf = (JTextField) e.getSource();
        if (tf.equals("textTableNum")) {
            tn = tf.getText();
        } else if (tf.equals("waiterName")) {
            wn = tf.getText();
        }


        String cmd = e.getActionCommand();
        if (cmd.equals("Delete")) {
            totallabel.setVisible(false);
            ListSelectionModel selmodel = list.getSelectionModel();
            int index = selmodel.getMinSelectionIndex();
            String foodName = (String) list.getSelectedValue();
            Subtraction(getPrices(foodName));
            totallabel.setVisible(true);
            //subtracts from the subtotal
            if (index >= 0) {
                model.remove(index);
            }
        } else if (cmd.equals("Clear all")) {
            model.clear();
            resetCalculator();

        }
    }

    //combobox mouse listener
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JComboBox cb = (JComboBox) e.getSource();
            getSelectedMenuItem(cb);
        }
    }

    private String setTotalLabelAmount() {
        String totlab = "Subtotal: $ " + subtotal + " Tax: $" + tax + "\n" + "Total: $ " + total;
        return totlab;
    }
}