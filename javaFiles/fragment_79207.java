package studInfoAndSubj;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class StudSubj extends JFrame {

    private StudInfo sI;

    // Labels
    private JLabel addSubjL = new JLabel("Add Subject: ", SwingConstants.CENTER);

    // Buttons
    private JButton doneB = new JButton("Done");
    private JButton backB = new JButton("Back");
    private ButtonHandler bH = new ButtonHandler();

    // Text Value Handlers
    private String semesterS;
    private String[] semester;
    private int selectedSubj;
    private String selectedSubjTime;

    // Subject Lists
    private String[] sem1Subj = {"College Algebra\nMWF\n12:00PM-1:00PM", 
    "Communication Arts 1\nMWF\n9:00AM-10:00AM", 
    "Information Technology Fundamentals - Lec\nTTH\n7:30AM-8:30AM", 
    "Information Technology Fundamentals - Lab\nT\n9:00AM-12:00PM", 
    "Programming 1\nMWF\n7:00AM-9:00AM"};
    private String[] sem1AddSubj = {"", "Filipino Christian Living\nMWF\n7:00AM-9:00AM", 
    "Foundation of Physical Education\nTH\n10:00AM-12:00PM", 
    "Komunikasyon sa Akademikong Filipino\nMWF\n9:00AM-10:00AM"};
    private String[] sem2Subj = {"Trigonometry\nMWF\n7:00AM-8:00AM", 
    "Communication Arts 2\nTTH\n9:00AM-10:30AM", 
    "Programming 2\nMWF\n9:00AM-11:00AM", 
    "Database Management Systems\nMWF\n8:00AM-9:00AM", 
    "Network Management\nTTH\n7:30AM-9:00AM"};
    private String[] sem2AddSubj = {"", "Environmental Science\nMWF\n8:00AM-9:00AM", 
    "Social Dances\nM\n12:00PM-2:00PM", 
    "General Psychology\nT\n12:00PM-1:00PM"};

    // Subject Time
    private String[] sem1SubjTime = {"MWF12:00PM-1:00PM", "MWF9:00AM-10:00AM", "TTH7:30AM-8:30AM", 
    "T9:00AM-12:00PM", "MWF7:00AM-9:00AM"};
    private String[] sem1AddSubjTime = {"MWF7:00AM-9:00AM", "TH10:00AM-12:00PM", "MWF9:00AM-10:00AM"};
    private String[] sem2SubjTime = {"MWF7:00AM-8:00AM", "TTH9:00AM-10:30AM", "MWF9:00AM-11:00AM", 
    "MWF8:00AM-9:00AM", "TTH7:30AM-9:00AM"};
    private String[] sem2AddSubjTime = {"MWF8:00AM-9:00AM", "M12:00PM-2:00PM", "T12:00PM-1:00PM"};

    // Layouts ((components + rows - 1) / rows)
    private Container pane = getContentPane();
    private Container two = new JPanel(new GridLayout(0, 2));

    // Combo Boxes
    private JComboBox<String> sem1AddSubjCB = new JComboBox<>(sem1AddSubj);
    private JComboBox<String> sem2AddSubjCB = new JComboBox<>(sem2AddSubj);

    // Window Size
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 250;

    private JLabel sem1Subj1 = new JLabel(sem1Subj[0]);
    private JLabel sem1Subj2 = new JLabel(sem1Subj[1]);
    private JLabel sem1Subj3 = new JLabel(sem1Subj[2]);
    private JLabel sem1Subj4 = new JLabel(sem1Subj[3]);
    private JLabel sem1Subj5 = new JLabel(sem1Subj[4]);

    // 2nd Semester Subjects
    private JLabel sem2Subj1 = new JLabel(sem2Subj[0]);
    private JLabel sem2Subj2 = new JLabel(sem2Subj[1]);
    private JLabel sem2Subj3 = new JLabel(sem2Subj[2]);
    private JLabel sem2Subj4 = new JLabel(sem2Subj[3]);
    private JLabel sem2Subj5 = new JLabel(sem2Subj[4]);

    public StudSubj(StudInfo sI) 
    {
        this.sI = sI;

        DefaultListCellRenderer dlcr2 = new DefaultListCellRenderer(); 
        doneB.addActionListener(bH);
        backB.addActionListener(bH);
        dlcr2.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
        sem1AddSubjCB.setRenderer(dlcr2);
        sem2AddSubjCB.setRenderer(dlcr2);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Border border2 = BorderFactory.createLineBorder(Color.BLUE, 1);
        sem1Subj1.setBorder(border2);
        sem2Subj1.setBorder(border2);

        sem1Subj2.setBorder(border2); 
        sem2Subj2.setBorder(border2);

        sem1Subj3.setBorder(border2);   
        sem2Subj3.setBorder(border2);

        sem1Subj4.setBorder(border2);   
        sem2Subj4.setBorder(border2);

        sem1Subj5.setBorder(border2);   
        sem2Subj5.setBorder(border2);

        addSubjL.setBorder(border2);
    }

    public void build() {
        pane.add(two);

        semesterS = sI.getSemValue();
        semester = sI.getSemCBValue();

        if(semesterS.equals(semester[0])) {
            setTitle("(BSIT - I - 1st Semester) List Of Subjects");
            two.add(sem1Subj1);
            two.add(sem1Subj2);
            two.add(sem1Subj3);
            two.add(sem1Subj4);
            two.add(sem1Subj5);
            two.add(addSubjL);
            two.add(sem1AddSubjCB);

        } else if(semesterS.equals(semester[1])) {
            setTitle("(BSIT - I - 2nd Semester) List Of Subjects");
            two.add(sem2Subj1);
            two.add(sem2Subj2);
            two.add(sem2Subj3);
            two.add(sem2Subj4);
            two.add(sem2Subj5);
            two.add(addSubjL);
            two.add(sem2AddSubjCB);
        }

        two.add(backB);
        two.add(doneB);

        repaint();
        revalidate();

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == doneB) {
                int ctr;

                if(semesterS.equals(semester[0]))
                {
                    selectedSubj = sem1AddSubjCB.getSelectedIndex()-1;
                    selectedSubjTime = sem1AddSubjTime[selectedSubj];

                    for(ctr = 0; ctr < sem1SubjTime.length; ctr++)
                    {
                        if(selectedSubjTime.equals(sem1SubjTime[ctr])) {
                        JOptionPane.showMessageDialog(null, "Choosen Subject has same time with the others!", "Error", 0);
                        } else {
                        sem1AddSubjCB.getSelectedItem();
                        }

                    }

                } else if(semesterS.equals(semester[1])) {
                    selectedSubj = sem2AddSubjCB.getSelectedIndex()-1;
                    selectedSubjTime = sem2AddSubjTime[selectedSubj];

                    for(ctr = 0; ctr < sem2SubjTime.length; ctr++)
                    {

                        if(selectedSubjTime.equals(sem2SubjTime[ctr]))
                        {
                            JOptionPane.showMessageDialog(null, "Choosen Subject has same time with the others!", "Error", 0);
                        } else {
                            sem2AddSubjCB.getSelectedItem();
                        }
                    }
                }
            } else if(e.getSource() == backB) {
                setVisible(false);
                sI.setVisible(true);
            }
        }   
    }
}