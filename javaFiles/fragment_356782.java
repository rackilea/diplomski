import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExamGradesGUI {
    public static void main(String[] args) {
        new ExamGradesGUI();
    }

    String[] firstName = new String[20];
    String[] lastName = new String[20];
    String[] subjectUnit = new String[20];
    double[] examMark = new double[20];
    private JLabel firstNameLbl, lastNameLbl, unitLbl, markLbl;
    private JTextField firstNameTxt, lastNameTxt, subjectUnitTxt, examMarkTxt;
    private JComboBox<String> unitCombo;
    private JButton btnClear, btnSave, btnOpen, btnExit;
    private JPanel panel;
    private JFrame frame;

    public ExamGradesGUI(){
        buildFrame();
        buildFields();
        buildButtons();
        frame.setVisible(true);
        frame.add(panel);
    }

    public void buildFrame(){
        frame = new JFrame("GradeEnter");
        frame.setSize(650,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
    }

    public void buildFields(){

        // Labels, User Input + Location

        firstNameTxt = new JTextField(10);
        firstNameTxt.setBounds(180, 80, 150, 20);
        panel.add(firstNameTxt);

        String str = firstNameTxt.getText(); 
        if(str.matches("[-a-zA-Z]*"))
        {
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter amount donating");
        }

        lastNameTxt = new JTextField(10);
        lastNameTxt.setBounds(180, 110, 150, 20);
        panel.add(lastNameTxt);

        subjectUnitTxt = new JTextField(10);
        String[] courses = {"Computing","Forensic","Business"};
        unitCombo = new JComboBox<String>(courses);
        //subjectUnitTxt.setBounds(180, 140, 150, 20);
        //panel.add(subjectUnitTxt);
        unitCombo.setBounds(180, 140, 150, 20);
        panel.add(unitCombo);

        // IF HAVE TIME: Turn Combo Box into GUI - Refer to testgui.java

        examMarkTxt = new JTextField(10);
        examMarkTxt.setBounds(180, 170, 150, 20);
        panel.add(examMarkTxt);

        firstNameLbl = new JLabel("First Name:");
        firstNameLbl.setBounds(70, 80, 100, 20);
        panel.add (firstNameLbl);

        lastNameLbl = new JLabel("Last Name:");
        lastNameLbl.setBounds(70, 110, 100, 20);
        panel.add (lastNameLbl);

        unitLbl = new JLabel("Unit:");
        unitLbl.setBounds(70, 140, 100, 20);
        panel.add (unitLbl);

        markLbl = new JLabel("Mark:");
        markLbl.setBounds(70, 170, 100, 20);
        panel.add (markLbl);

    }

    public void buildButtons() {
        btnClear = new JButton ("Reset Fields");
        btnClear.setBounds(55, 220, 110, 20);
        btnClear.addActionListener(new ClearButtonListener());
        panel.add (btnClear);

        btnSave = new JButton ("Save");
        btnSave.setBounds(155, 220, 70, 20);
        btnSave.addActionListener(new SaveButton());
        panel.add (btnSave);

        btnOpen = new JButton ("Open 'GradeEnter.txt' ");
        btnOpen.setBounds(90, 250, 200, 20);
        btnOpen.addActionListener(new OpenButton());
        panel.add (btnOpen);


        btnExit = new JButton ("Exit");
        btnExit.setBounds(255, 220, 70, 20);
        btnExit.addActionListener(new ExitButton());
        panel.add (btnExit);

    }
    public void setText() {
        firstNameTxt.setText("");
        lastNameTxt.setText("");
        subjectUnitTxt.setText("");
        examMarkTxt.setText("");
    }

    public void getText() {
        int i = 0;
        i++;
        firstName[i] = firstNameTxt.getText();
        lastName[i] = lastNameTxt.getText();
        subjectUnit[i] = unitCombo.getItemAt(unitCombo.getSelectedIndex());
        examMark[i] = Double.parseDouble(examMarkTxt.getText());
    }
    private class ClearButtonListener implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            setText();
        }
    }

    private class SaveButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            getText();
            setText();

            ExamGrades save = new ExamGrades();
            save.fileOpen();
            save.addRecords(firstName, lastName, subjectUnit, examMark);
            JOptionPane.showMessageDialog(null, "Entry Saved!");
            save.fileClose();

        }
    }
    private class OpenButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try { 
                JOptionPane.showMessageDialog(null, "'GradeEnter.txt' opening in Java!"); 
                Thread.sleep(2); // Adds a 2 second delay so user can read dialog message
                Runtime.getRuntime().exec("eclipse GradeEnter.txt" );


            } catch (Exception NoFileFound) { 
                System.out.println("Couldn't open or find the file.");
            } 
        }
    }

    class ExitButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int n = JOptionPane.showConfirmDialog(frame, 
                    "Are you sure you want to exit?", 
                    "Exit?", 
                    JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }

}