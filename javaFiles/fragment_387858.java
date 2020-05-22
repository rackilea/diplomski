import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Roster
{
   private static ArrayList<Student> studentList = new ArrayList<>();

   public static void main(String[] args)
    {

        add(1, "John", "Smith", "John1989@gmail.com", 20, 88, 79, 59);
        add(2, "Suzan", "Erickson", "Erickson_1990@gmailcom", 19, 91, 72, 85);
        add(3, "Jack", "Napoli", "The_lawyer99yahoo.com", 19, 85, 84, 87);
        add(4, "Erin", "Black", "Erin.black@comcast.net", 22, 91, 98, 82);
        print_all();
        print_invalid_emails();
        print_average_grade(2);
        remove(3);
        remove(3);    
    }

   public static void add (int studentID, String firstName, String lastName, String email, int age, int grade1, int grade2, int grade3)
   {
       int[] grades = {grade1, grade2, grade3};
       Student newStudent = new Student (studentID, firstName, lastName, email, age, grades);
       studentList.add(newStudent);
   }

  public static void remove(int studentID) 
  {
      for (Student i: studentList) {
          if (i.getStudentID() == studentID) {
              studentList.remove(i);
              System.out.println("Student Removed");
            } 
          else {
            System.out.println("A student with this ID(studentID) was not found.");
            return;
            }  

        }
  }
  public static void print_all (){
    for (Student i: studentList) {
        i.print();
    }
  }
  public static void print_average_grade(int studentID) {
      studentList.get(studentID).getAverageGrade();
 }

 public static void print_invalid_emails() {
     String RFC5322 = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
     Pattern pattern = Pattern.compile(RFC5322);
     for (Student i: studentList) {
         String email = i.getEmail();
         Matcher matcher = pattern.matcher(email);
         System.out.println(email +":\t"+ matcher.matches());
     }

 }


}