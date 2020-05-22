import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AdminWindow extends JDialog implements ActionListener {

    private JPanel adminPanel1, adminPanel2, adminPanel3;
    private JTabbedPane tabPane;
    private GridBagConstraints g1, g2, g3;
    private JLabel idLbl, showLbl, descLbl, ageLbl, imgLbl, timeLbl, screenLbl,
            stanLbl, vipLbl, idLbl1, showLbl1, descLbl1, ageLbl1, imgLbl1, imgName;
    private JTextField idTxt, showTxt, imgTxt, timeTxt, stanTxt, vipTxt,
            idTxt1, showTxt1, imgTxt1;
    private JTextArea descTxt, descTxt1;
    private JComboBox ageCb, ageCb1, screenCb, timeCb, showingCb;
    private JScrollPane descTxtPane, descTxtPane1;
    private ArrayList<String> screenList, timeList, showingList;
    private DefaultComboBoxModel screenModel, timeModel, showingModel;
    private JButton submit, clear, seatSubmit, seatClear, addBtn, subBtn,
            submit1, clear1, imgBtn;
    private double stanPrice, vipPrice;
    private String stanPriceString, vipPriceString, priceExpression, imgString;
    private Pattern p;
    private File dest, chosenFile;

    public AdminWindow() {

        //frame properties
        setTitle("Admin Panel");
        //setSize(Dimensions.getScreenWidth() - 100, Dimensions.getScreenHeight() - 100);
        setAlwaysOnTop(true);
//        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //regular expression validations
        priceExpression = "[0-9]{1,2}[.]{1}[0-9]{2}";
        p = Pattern.compile(priceExpression);

        //panel dec
        tabPane = new JTabbedPane();
        adminPanel1 = new JPanel();
        adminPanel2 = new JPanel();
        adminPanel3 = new JPanel();
        g1 = new GridBagConstraints();
        g2 = new GridBagConstraints();
        g3 = new GridBagConstraints();

        //label dec
        idLbl = new JLabel("Film ID");
        showLbl = new JLabel("Film Name");
        descLbl = new JLabel("Film Description");
        ageLbl = new JLabel("Age Rating");
        imgLbl = new JLabel("Image");
        idLbl1 = new JLabel("Film ID");
        showLbl1 = new JLabel("Film Name");
        descLbl1 = new JLabel("Film Description");
        ageLbl1 = new JLabel("Age Rating");
        imgLbl1 = new JLabel("Image");
        timeLbl = new JLabel("Showing Times");
        screenLbl = new JLabel("Screen Number");
        stanLbl = new JLabel("Standard Ticket Cost (£)");
        vipLbl = new JLabel("VIP Ticket Cost (£)");
        imgName = new JLabel("filename.jpg");

        //label properties
//        imgName.setPreferredSize(new Dimension(100, 20));

        //txttfield dec
        idTxt = new JTextField(4);
        showTxt = new JTextField(30);
        descTxt = new JTextArea(4, 30);
        descTxtPane = new JScrollPane(descTxt, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        imgTxt = new JTextField();
        idTxt1 = new JTextField(4);
        showTxt1 = new JTextField(30);
        descTxt1 = new JTextArea(4, 30);
        descTxtPane1 = new JScrollPane(descTxt1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        imgTxt1 = new JTextField();
        timeTxt = new JTextField(4);
        stanTxt = new JTextField(4);
        vipTxt = new JTextField(4);

        //textfield properties
        idTxt1.setEditable(false);
        descTxt.setWrapStyleWord(true);
        descTxt.setLineWrap(true);

        //drop-down dec
        ageCb = new JComboBox();
        ageCb1 = new JComboBox();
        screenCb = new JComboBox();
        timeCb = new JComboBox();
        showingCb = new JComboBox();

        //dropdown properties
//        timeCb.setPreferredSize(new Dimension(60, 23));

        //buttons
        submit = new JButton("Submit");
        clear = new JButton("Clear");
        submit1 = new JButton("Submit");
        clear1 = new JButton("Clear");
        seatSubmit = new JButton("Submit");
        seatClear = new JButton("Show Current");
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        imgBtn = new JButton("Browse..");

        //button properties
        addBtn.setFocusPainted(false);
        subBtn.setFocusPainted(false);
        addBtn.setMargin(new Insets(0, 5, 0, 5));
        subBtn.setMargin(new Insets(0, 5, 0, 5));

        //listeners
        submit.addActionListener(this);
        clear.addActionListener(this);
        seatSubmit.addActionListener(this);
        seatClear.addActionListener(this);
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        imgBtn.addActionListener(this);

        //fill price text fields with existing prices
        defaultForm();

        //add items to jcombobox
        ageCb.addItem("U");
        ageCb.addItem("12A");
        ageCb.addItem("15");
        ageCb.addItem("18");
        ageCb1.addItem("U");
        ageCb1.addItem("12A");
        ageCb1.addItem("15");
        ageCb1.addItem("18");

        //panel properties
        adminPanel1.setLayout(new GridBagLayout());
        adminPanel2.setLayout(new GridBagLayout());
        adminPanel3.setLayout(new GridBagLayout());
        adminPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "New Showing"));
        adminPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Seat Prices"));
        adminPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Edit Showing"));

        //ading panels to tabbed pane
        tabPane.addTab("Add Showings", null, adminPanel1, "Add new showings & showing times");
        tabPane.addTab("Seat Prices", null, adminPanel2, "Change seat prices");
        tabPane.addTab("Edit Showing", null, adminPanel3, "Edit existing showing");

        //-----adding components to pane--------------------------------------!
        g1.gridx = 0;
        g1.gridy = 0;
        g1.insets = new Insets(10, 0, 0, 10);
        g1.anchor = GridBagConstraints.LINE_END;
        adminPanel1.add(idLbl, g1);
        g1.gridx++;
        g1.anchor = GridBagConstraints.LINE_START;
    g1.fill = GridBagConstraints.HORIZONTAL;
    adminPanel1.add(idTxt, g1);
    g1.fill = GridBagConstraints.NONE;
        g1.gridy++;
        g1.gridx--;
        g1.anchor = GridBagConstraints.LINE_END;
        adminPanel1.add(showLbl, g1);
        g1.gridx++;
        g1.anchor = GridBagConstraints.LINE_START;
        g1.gridwidth = 4;
        g1.fill = GridBagConstraints.HORIZONTAL;
        adminPanel1.add(showTxt, g1);
        g1.fill = GridBagConstraints.NONE;
        g1.gridwidth = 1;
        g1.gridy++;
        g1.gridx--;
        g1.anchor = GridBagConstraints.LINE_END;
        adminPanel1.add(descLbl, g1);
        g1.gridx++;
        g1.anchor = GridBagConstraints.LINE_START;
        g1.gridwidth = 4;
        g1.fill = GridBagConstraints.BOTH;
        g1.weightx = 1;
        g1.weighty = 1;
        adminPanel1.add(descTxtPane, g1);
        g1.fill = GridBagConstraints.NONE;
        g1.weightx = 0;
        g1.weighty = 0;
        g1.gridwidth = 1;
        g1.gridy++;
        g1.gridx--;
        g1.anchor = GridBagConstraints.LINE_END;
        adminPanel1.add(ageLbl, g1);
        g1.gridx++;
        g1.anchor = GridBagConstraints.LINE_START;
        adminPanel1.add(ageCb, g1);
        g1.gridy++;
        g1.gridx--;
        g1.anchor = GridBagConstraints.LINE_END;
        adminPanel1.add(imgLbl, g1);
        g1.gridx++;
        g1.anchor = GridBagConstraints.LINE_START;
        g1.gridwidth = 2;
        adminPanel1.add(imgBtn, g1);
        g1.gridx = 3;
        adminPanel1.add(imgName, g1);
        g1.gridwidth = 1;
        g1.gridy++;
        g1.gridx = 0;
        g1.anchor = GridBagConstraints.LINE_END;
        adminPanel1.add(screenLbl, g1);
        g1.gridx++;
        g1.anchor = GridBagConstraints.LINE_START;
        adminPanel1.add(screenCb, g1);
        g1.gridx--;
        g1.gridy++;
        g1.anchor = GridBagConstraints.LINE_END;
        adminPanel1.add(timeLbl, g1);
        g1.gridx++;
        g1.anchor = GridBagConstraints.LINE_START;
        g1.fill = GridBagConstraints.HORIZONTAL;
        adminPanel1.add(timeTxt, g1);
        g1.fill = GridBagConstraints.NONE;
        g1.gridx++;
        adminPanel1.add(addBtn, g1);
        g1.gridx++;
        adminPanel1.add(timeCb, g1);
        g1.gridx++;
        adminPanel1.add(subBtn, g1);
        //buttons
        g1.gridy++;
        g1.gridx = 0;
        g1.insets = new Insets(10, 0, 10, 10); //top, right, bottom, left
        g1.anchor = GridBagConstraints.LINE_END;
        adminPanel1.add(clear, g1);
        g1.gridx++;
        g1.anchor = GridBagConstraints.LINE_START;
        g1.gridwidth = 4;
        adminPanel1.add(submit, g1);
        g1.gridwidth = 1;

        //------adding components to panel2-----------------------------------!
        //left
        g2.gridx = 0;
        g2.gridy = 0;
        g2.insets = new Insets(10, 10, 0, 10);
        g2.anchor = GridBagConstraints.LINE_END;
        adminPanel2.add(stanLbl, g2);
        g2.gridy++;
        adminPanel2.add(vipLbl, g2);
        g2.gridy++;
        adminPanel2.add(seatClear, g2);
        //right
        g2.gridy = 0;
        g2.gridx++;
        g2.anchor = GridBagConstraints.LINE_START;
        g2.fill = GridBagConstraints.HORIZONTAL;
        adminPanel2.add(stanTxt, g2);
        g2.fill = GridBagConstraints.NONE;
        g2.gridy++;
        g2.fill = GridBagConstraints.HORIZONTAL;
        adminPanel2.add(vipTxt, g2);
        g2.fill = GridBagConstraints.NONE;
        g2.gridy++;
        adminPanel2.add(seatSubmit, g2);

        //-----adminpanel3-----------------------------------------------------
        //adding components to panel1
        g3.gridx = 1;
        g3.gridy = 0;
        g3.insets = new Insets(10, 0, 0, 10);
        g3.anchor = GridBagConstraints.LINE_START;
        g3.gridwidth = 4;
        adminPanel3.add(showingCb, g3);
        g3.gridwidth = 1;
        g3.gridx--;
        g3.gridy++;
        g3.anchor = GridBagConstraints.LINE_END;
        adminPanel3.add(idLbl1, g3);
        g3.gridx++;
        g3.anchor = GridBagConstraints.LINE_START;
        g3.fill = GridBagConstraints.HORIZONTAL;
        adminPanel3.add(idTxt1, g3);
        g3.fill = GridBagConstraints.NONE;
        g3.gridy++;
        g3.gridx--;
        g3.anchor = GridBagConstraints.LINE_END;
        adminPanel3.add(showLbl1, g3);
        g3.gridx++;
        g3.anchor = GridBagConstraints.LINE_START;
        g3.gridwidth = 5;
        g3.fill = GridBagConstraints.HORIZONTAL;
        adminPanel3.add(showTxt1, g3);
        g3.fill = GridBagConstraints.NONE;
        g3.gridwidth = 1;
        g3.gridy++;
        g3.gridx--;
        g3.anchor = GridBagConstraints.LINE_END;
        adminPanel3.add(descLbl1, g3);
        g3.gridx++;
        g3.anchor = GridBagConstraints.LINE_START;
        g3.gridwidth = 4;
        g3.fill = GridBagConstraints.BOTH;
        g3.weightx = 1;
        g3.weighty = 1;
        adminPanel3.add(descTxtPane1, g3);
        g3.fill = GridBagConstraints.NONE;
        g3.weightx = 0;
        g3.weighty = 0;
        g3.gridwidth = 1;
        g3.gridy++;
        g3.gridx--;
        g3.anchor = GridBagConstraints.LINE_END;
        adminPanel3.add(ageLbl1, g3);
        g3.gridx++;
        g3.anchor = GridBagConstraints.LINE_START;
        adminPanel3.add(ageCb1, g3);
        g3.gridy++;
        g3.gridx--;

        //buttons
        g3.gridy++;
        g3.gridx = 0;
        g3.insets = new Insets(10, 0, 10, 10); //top, right, bottom, left
        g3.anchor = GridBagConstraints.LINE_END;
        adminPanel3.add(clear1, g3);
        g3.gridx++;
        g3.anchor = GridBagConstraints.LINE_START;
        g3.gridwidth = 4;
        adminPanel3.add(submit1, g3);
        g3.gridwidth = 1;

        //adding tabbed pane to frame
        this.add(tabPane);
        this.pack();

        //visibility
        setVisible(true);
        tabPane.setVisible(true);

        //actionlisteners
    }

    public static void main(String[] args) {
        AdminWindow test = new AdminWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == imgBtn) {

            //--JFileChooser, ugly but better to use--
            String userDir = System.getProperty("user.home");
            JFileChooser chooser = new JFileChooser(userDir + "/Desktop");
            int choice = chooser.showDialog(this, "Choose");
            if (choice != JFileChooser.APPROVE_OPTION) {
                return;
            }

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.addChoosableFileFilter(filter);
            chosenFile = chooser.getSelectedFile();
            imgName.setText(chosenFile.getName());
            dest = new File(System.getProperty("user.dir") + "/src/iegroup/resources", chosenFile.getName());
            imgString = "resources/" + chosenFile.getName();
            System.out.println(dest.toPath());
        }

        if (e.getSource() == submit) {

            if (e.getSource() == clear) {

            }

            if (e.getSource() == seatSubmit) {

            }
        }
        if (e.getSource() == seatClear) {
            defaultForm();
        }

        if (e.getSource() == addBtn) {

            timeModel.addElement(timeTxt.getText());
            timeList.add(timeTxt.getText());
        }
        if (e.getSource() == subBtn) {
            timeModel.removeElement(timeCb.getSelectedItem());
            timeList.remove(timeCb.getSelectedItem());
        }
    }

    private void defaultForm() {

        stanPriceString = String.format("%.2f", stanPrice);
        vipPriceString = String.format("%.2f", vipPrice);
        stanTxt.setText(stanPriceString);
        vipTxt.setText(vipPriceString);
    }

    public void showValidationPrompt(String message) {
        JFrame validFrame = new JFrame();
        validFrame.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(validFrame, message, "Invalid input", JOptionPane.CLOSED_OPTION);

    }

    public void showSuccessPrompt(String message) {
        JFrame errorFrame = new JFrame();
        errorFrame.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(errorFrame, message, "Success", JOptionPane.CLOSED_OPTION);

    }
}