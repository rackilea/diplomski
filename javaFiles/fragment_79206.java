package studInfoAndSubj;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class StudInfo extends JFrame {

    private StudSubj sJ;

    // Labels
    private JLabel nameL = new JLabel("Student Name: ", SwingConstants.CENTER);
    private JLabel snameL = new JLabel("(Surname)", SwingConstants.CENTER);
    private JLabel fnameL = new JLabel("(First Name)", SwingConstants.CENTER);
    private JLabel mnameL = new JLabel("(Middle Name)", SwingConstants.CENTER);
    private JLabel courseL = new JLabel("Course: ", SwingConstants.CENTER);
    private JLabel yearL = new JLabel("Year: ", SwingConstants.CENTER);
    private JLabel semesterL = new JLabel("Semester: ", SwingConstants.CENTER);

    // Text Fields
    private JTextField snameTF = new JTextField(10);
    private JTextField fnameTF = new JTextField(10);
    private JTextField mnameTF = new JTextField(10);

    // Text Value Handlers
    private String snameS, fnameS, mnameS, courseS, yearS, semesterS;

    // Buttons
    private JButton nextB = new JButton("Next");
    private JButton cancelB = new JButton("Cancel");
    private ButtonHandler bH = new ButtonHandler();

    // Layouts ((components + rows - 1) / rows)
    private Container pane = getContentPane();
    private Container one = new JPanel(new GridLayout(0, 6));

    // Combo Boxes
    private String[] course = {"BSIT"};
    private String[] year = {"I"};
    private String[] semester = {"1ST", "2ND"};
    private JComboBox<String> courseCB = new JComboBox<>(course);
    private JComboBox<String> yearCB = new JComboBox<>(year);
    private JComboBox<String> semesterCB = new JComboBox<>(semester);

    // Spaces
    private JLabel blank1 = new JLabel(""); 
    private JLabel blank2 = new JLabel("");
    private JLabel blank3 = new JLabel("");
    private JLabel blank4 = new JLabel("");
    private JLabel blank5 = new JLabel("");
    private JLabel blank6 = new JLabel("");
    private JLabel blank7 = new JLabel("");

    // Window Size
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 250;

    public StudInfo() // and this is line 65
    {
        DefaultListCellRenderer dlcr1 = new DefaultListCellRenderer(); 
        dlcr1.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
        courseCB.setRenderer(dlcr1);
        yearCB.setRenderer(dlcr1);
        semesterCB.setRenderer(dlcr1);
        snameTF.setHorizontalAlignment(JTextField.CENTER);
        fnameTF.setHorizontalAlignment(JTextField.CENTER);
        mnameTF.setHorizontalAlignment(JTextField.CENTER);
        snameL.setVerticalAlignment(SwingConstants.TOP);
        fnameL.setVerticalAlignment(SwingConstants.TOP);
        mnameL.setVerticalAlignment(SwingConstants.TOP);

        nextB.addActionListener(bH);
        cancelB.addActionListener(bH);

        Border border1 = BorderFactory.createLineBorder(Color.BLUE, 1);
        courseL.setBorder(border1);
        yearL.setBorder(border1);
        semesterL.setBorder(border1);

        pane.add(one);
        one.add(blank1);
        one.add(nameL);                         
        one.add(snameTF);
        one.add(fnameTF);
        one.add(mnameTF);
        one.add(blank2);
        one.add(blank3);
        one.add(blank4);
        one.add(snameL);
        one.add(fnameL);
        one.add(mnameL);
        one.add(blank5);
        one.add(courseL);
        one.add(courseCB);
        one.add(yearL);
        one.add(yearCB);
        one.add(semesterL);
        one.add(semesterCB);
        one.add(blank6);
        one.add(blank7);
        one.add(cancelB);
        one.add(nextB);

        setTitle("Student Information");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sJ = new StudSubj(this);
    }

    public String getSemValue()
    {
        return semesterS;
    }

    public String[] getSemCBValue()
    {
        return semester;
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == nextB) {
                snameS = snameTF.getText();
                fnameS = fnameTF.getText();
                mnameS = mnameTF.getText();
                courseS = courseCB.getSelectedItem().toString();
                yearS = yearCB.getSelectedItem().toString();
                semesterS = semesterCB.getSelectedItem().toString();


                setVisible(false);
                sJ.build();
            } else if(e.getSource() == cancelB) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) 
    {
        StudInfo studInfo = new StudInfo();
    }
}