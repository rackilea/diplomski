import javax.swing.JOptionPane;
public class CollegeCourse {

protected String dept;
protected int courseNum;
protected int cred;
protected int fee;
protected int Charge = 120;
protected int labfee;

public CollegeCourse(String dept, int courseNum, int cred)
{
    this.dept = dept;
    this.courseNum = courseNum;
    this.cred = cred;
    fee = cred * Charge;
}

public void display(){

    JOptionPane.showMessageDialog(null, dept + courseNum + 
            "\nNon-lab Course" + "\n" + cred +" Credits" + "\nTotal fee is $" + fee);
 }
}