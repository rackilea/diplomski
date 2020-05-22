package self.edu.stackoverflow;

import java.applet.Applet;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaticFinal extends Applet implements ActionListener {
private TextField gradeField, finalField;
private Button enter;

double mp1 = 0;
double mp2 = 0;
double exam1 = 0;
double mp3 = 0;
double mp4 = 0;
double exam2 = 0;
double finalGrade = 0;
char letterGrade;

public void init() {
    gradeField = new TextField(8);
    gradeField.addActionListener(this);
    add(gradeField);

    enter = new Button("Enter MP1 Grade");
    enter.addActionListener(this);
    add(enter);

    finalField = new TextField(8);
    finalField.addActionListener(this);
    add(finalField);
}

public void actionPerformed(ActionEvent e) {

    // if (e.getSource() == gradeField || e.getSource() == enter)

    if (enter.getLabel() == "Enter MP1 Grade") {
        mp1 = Double.parseDouble(gradeField.getText());
        enter.setLabel("Enter MP2 Grade");
    } else if (enter.getLabel() == "Enter MP2 Grade") {
        mp2 = Double.parseDouble(gradeField.getText());
        enter.setLabel("Enter Exam1 Grade");
    } else if (enter.getLabel() == "Enter Exam1 Grade") {
        exam1 = Double.parseDouble(gradeField.getText());
        enter.setLabel("Enter MP3 Grade");
    } else if (enter.getLabel() == "Enter MP3 Grade") {
        mp3 = Double.parseDouble(gradeField.getText());
        enter.setLabel("Enter MP4 Grade");
    } else if (enter.getLabel() == "Enter MP4 Grade") {
        mp4 = Double.parseDouble(gradeField.getText());
        enter.setLabel("Enter Exam2 Grade");
    } else if (enter.getLabel() == "Enter Exam2 Grade") {
        exam2 = Double.parseDouble(gradeField.getText());
        enter.setLabel("Calculate Final Grade");
    } else if (enter.getLabel() == "Calculate Final Grade") {
        finalGrade = Math1.calcAverage(mp1, mp2, exam1, mp3, mp4, exam2);
        letterGrade = Math1.getLetter(finalGrade);
        finalField.setText(letterGrade + " - " + finalGrade);
        enter.setLabel("Enter MP1 Grade");
    }

}