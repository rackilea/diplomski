import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class Test2 {

    public static void main(String args[]) throws Exception {
        new SearchAll().setVisible(true);

    }

    public static class SearchAll extends JFrame implements ActionListener {
        private int selectedRow;

        //JOptionPane
        //Confirm Dialog
        private int dialogButton = JOptionPane.YES_NO_OPTION;


        //GUI RELATED
        private JTable table = new JTable();

        //JButtons
        private JButton btnDelete = new JButton("Delete");
        private JButton btnEdit = new JButton("Edit");
        private JButton saveMember = new JButton("Save member");
        private JButton btnBack = new JButton("Back");

        //Containers, panels
        Container mainCon = this.getContentPane();
        JPanel formPanel = new JPanel();

        //Adding scroll pane here - to formPanel which holds everything.
        JScrollPane scrollPane = new JScrollPane(formPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        /*TEXT FIELDS BOXES *******************************/
        private JLabel lblName = new JLabel("Name: ");
        private JTextField txtName = new JTextField("", 15);

        private JLabel lblEmail = new JLabel("Email: ");
        private JTextField txtEmail = new JTextField("", 15);

        private JLabel lblDescription = new JLabel("Description about you: ");
        private JTextArea txtDescription = new JTextArea("", 5, 15);
        /*TEXT FIELDS BOXES *******************************/

        /*COMBO BOXES *******************************/
        private JLabel lblCountry = new JLabel();
        private JComboBox comCountry = new JComboBox();

        private JLabel lblGenre = new JLabel();
        private JComboBox comGenre = new JComboBox();
        /*COMBO BOXES *******************************/

        /*RADIO BUTTONS *******************************/
        private JLabel lblMaleFemale = new JLabel("Gender: ");
        private JRadioButton radMale = new JRadioButton("Male: ");
        private JRadioButton radFemale = new JRadioButton("Female: ");
        private ButtonGroup buttonGroupMF = new ButtonGroup();

        private JLabel lblFreePaid = new JLabel("Membership Type: ");
        private JRadioButton radFree = new JRadioButton("Free: ");
        private JRadioButton radPaid = new JRadioButton("Paid: ");
        private ButtonGroup buttonGroupFP = new ButtonGroup();
        /*RADIO BUTTONS *******************************/

        /*PAID MEMBER STUFF *******************************/
        private JLabel lblCardNo = new JLabel("Card Number: ");
        private JTextField txtCardNo = new JTextField("", 15);

        private JLabel lblExpiry = new JLabel();
        private JComboBox comExpiry = new JComboBox();
        /*PAID MEMBER STUFF *******************************/

        //DB SQL Variables - 
        private String edName = "";
        private String edEmail = "";
        private String edDescription = "";
        private String edCountry = "";
        private String edGenre = "";
        private String edGender = "";
        private String edMembType = "";
        private String edCardNo = "";
        private Object edExpiry = "";
        private String edSongLim = "";

        //DB 
        private Connection conDB = null;
        private Statement stmt = null;
        private ResultSet r = null;

        //Validation isValid
        private boolean isValid;

        public SearchAll(){
            super("Search/Edit/Delete");
            this.setBounds(400, 500, 854,400);
//            this.setPreferredSize(new Dimension(500,500));
            this.setVisible(true);

            //Add table and GUI components
            mainCon.add(BorderLayout.NORTH, btnBack);
            btnBack.addActionListener(this);
            mainCon.add(scrollPane);


            formPanel.add(table);
            formPanel.add(btnDelete);
            formPanel.add(btnEdit);
            //Tried doing this - But didn't work. Just stayed static
//            formPanel.add(scrollPane);

            //Add action listeners

            btnEdit.addActionListener(this);
            btnDelete.addActionListener(this);

            //Set Selection model for table
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setModel(new DefaultTableModel(100, 8));

            ListSelectionModel rowSM = table.getSelectionModel();
            rowSM.addListSelectionListener(new ListSelectionListener()  {
                @Override
                public void valueChanged(ListSelectionEvent e){
                    ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                    selectedRow = lsm.getMinSelectionIndex();
                    System.out.println(selectedRow);
                }
            });

        }


        /*-------ACTION PERFORMED ------------------------------*/
        int editCounter = 0;
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnBack){
                this.dispose();
            }

                                //DELETE BUTTON BELOW
    /*########################################################################*/

            if(e.getSource() == btnDelete){

                System.out.println("Ran btnDelete");
            }
    /*########################################################################*/

                            //EDIT BUTTON BELOW

    /*########################################################################*/

            if(e.getSource() == btnEdit){
                if(editCounter == 0)
                {
                    System.out.println("Ran btnEdit");
                    editCounter++;
                }
                 else{
                    formPanel.repaint();
                    System.out.println("Stop duplicating form inputs");
                }

            }
    /*########################################################################*/

                            //SAVE MEMBER BUTTON BELOW

    /*########################################################################*/
            if(e.getSource() == saveMember){
                System.out.println("Ran btnSaveMember");
                 //UPDATE VALUES
                    if(radMale.isSelected()){
                        edGender = "Male";
                    }
                    else if(radFemale.isSelected()){
                        edGender = "Female";
                    }
                    if(radPaid.isSelected()){
                        edMembType = "Paid";
                        edSongLim = "100";
                        edCardNo = txtCardNo.getText();
                        edExpiry = comExpiry.getSelectedItem();
                        txtCardNo.setEnabled(true);

                    }
                    else{
                        edMembType = "Free";
                        edSongLim = "10";
                        edCardNo = "";
                        edExpiry = "";
                        txtCardNo.setEnabled(false);

                    }
               //Validate the form
               if(txtName.getText().equals(""))
               {
                   isValid = false;
                   JOptionPane.showMessageDialog(null, "Enter a name please");
               }
               else{
                   isValid = true;
                    if(txtEmail.getText().equals("")){
                      isValid = false; 
                      JOptionPane.showMessageDialog(null, "Enter an Email please");
                   }
                   else
                   {
                       isValid = true;
                        if(txtDescription.getText().equals("")){
                          isValid = false; 
                          JOptionPane.showMessageDialog(null, "Enter a Description please");
                       }
                       else
                       {
                           isValid = true;
                           if(radPaid.isSelected()){
                               if(txtCardNo.getText().equals("")){
                                   isValid = false; 
                                    JOptionPane.showMessageDialog(null, "Enter a Card Number please");
                               }
                               else{
                                   isValid = true;
                               }
                           }

                       }
                   }
               }
               //If the form is good, execute the update
               if(isValid){
               }
            }//End of saveMember Button
    }//End of action performed
     /*########################################################################*/      

                               //DELETE MEMBER BELOW

    /*#######################DELETE MEMBER####################################*/

    /*#########################################################################*/

                            //SAVE MEMBER BELOW

    /*#######################SAVE MEMBER####################################*/
    /*###########################################################################*/

                            //ADD INPUT FIELDS BELOW

     /*#######################INPUT FIELDS####################################*/   
        public void showInputFields(){
            formPanel.setLayout(new FlowLayout());

             /*TEXT FIELDS BOXES *******************************/
            formPanel.add(lblName);
            formPanel.add(txtName);

            formPanel.add(lblEmail);
            formPanel.add(txtEmail);

            formPanel.add(lblDescription);
            formPanel.add(txtDescription);
            /*TEXT FIELDS BOXES *******************************/



            /*COMBO BOXES *******************************/

            //Combo Box ( Countrys )
            formPanel.add(lblCountry);
            formPanel.add(comCountry);
            comCountry.addItem("Australia");
            comCountry.addItem("New Zealand");
            comCountry.addItem("Tasmania");
            comCountry.addActionListener(this);
            //Combo Box ( Fav Genre )
            formPanel.add(lblGenre);
            formPanel.add(comGenre);
            comGenre.addItem("Pop");
            comGenre.addItem("Rock");
            comGenre.addItem("Alternative");
            comGenre.addItem("Jazz");
            comGenre.addItem("Hip/Hop");

            comGenre.addActionListener(this);

            /*COMBO BOXES *******************************/


            /*RADIO BUTTONS BOXES *******************************/
            //Radio Buttons (Male/Female)
            buttonGroupMF.add(radMale);
            buttonGroupMF.add(radFemale);

            formPanel.add(radMale);
            formPanel.add(radFemale);

            radMale.addActionListener(this);
            radFemale.addActionListener(this);

            //Free or paid members ------ 
            buttonGroupFP.add(radFree);
            buttonGroupFP.add(radPaid);

            formPanel.add(radFree);
            formPanel.add(radPaid);

            radFree.addActionListener(this);
            radPaid.addActionListener(this);
            //Free or paid members ------ 
            /*RADIO BUTTONS BOXES *******************************/


            /*PAID MEMBER GUI *******************************/


            formPanel.add(lblCardNo);
            formPanel.add(txtCardNo);
            //Hide
            lblCardNo.setVisible(true);
            txtCardNo.setVisible(true);


            formPanel.add(lblExpiry);
            formPanel.add(comExpiry);
            comExpiry.addItem("2017");
            comExpiry.addItem("2018");
            comExpiry.addItem("2019");

            //Hide
            lblExpiry.setVisible(true);
            comExpiry.setVisible(true);
            comExpiry.addActionListener(this);

            /*PAID MEMBER GUI *******************************/

            //Add the button after everything
            formPanel.add(saveMember);
            saveMember.addActionListener(this);
        }
    /*###########################################################################*/

                            //EDIT MEMBER BELOW

     /*#######################EDIT MEMBER####################################*/
    /*##########################################################################*/


    }
}