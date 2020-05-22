import javax.swing.JOptionPane;

public class UseCourse
{   
    public UseCourse()
    {
        CollegeCourse college;
        // Collect all the necessary data first to determine whether it is a lab course or not.
        String dept = JOptionPane.showInputDialog(null, "Enter Department");

        String courseNumString = JOptionPane.showInputDialog(null, "Enter Course Number");
        int courseNum = Integer.parseInt(courseNumString);

        String credString = JOptionPane.showInputDialog(null, "Enter Credits");
        int cred = Integer.parseInt(credString);

        // Now that we have the info we can ask the question.
        if (dept.equals("BIO") | dept.equals("CHM") | dept.equals("CIS") | dept.equals("PHY"))
        {college = new LabCourse(dept, courseNum, cred);}

        else {college = new LabCourse(dept, courseNum, cred);}
        college.display();
    }

    public static void main(String[] args) 
    {new UseCourse();}
}