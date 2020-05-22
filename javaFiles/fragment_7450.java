import javax.swing.JOptionPane;
public class LabCourse extends CollegeCourse 
{
    public LabCourse(String dept, int courseNum, int cred)
    {super(dept, courseNum, cred);}

    public void display()
    {
        fee += 50;
        JOptionPane.showMessageDialog(null, dept + courseNum + 
                "\nLab Course" + "\n" + cred +" Credits" + "\nTotal fee is $" + fee);
    }  
}