package guitestclient;

import javax.swing.JOptionPane;

public class GUITestClient {
    public static void main(String[] args) {

        StudentInfo student = new StudentInfo();
        double credits;
        double gradePoints = 0;
        double gradePointsTot = 0;
        double gpa = 0;
        int classCount = 0;


        String name = JOptionPane.showInputDialog("Please enter your name:");
        student.setName(name);
      do{
        credits = Double.parseDouble(JOptionPane.showInputDialog("Please enter the credits:"));
        student.setCredits(credits);

        String grade = JOptionPane.showInputDialog("Please enter your grade:");
        student.setGrade(grade);

        //calculates gpa value for grade
        gradePoints = StudentInfo.addClass(gradePoints, grade);
        gradePointsTot += gradePoints;
        classCount++;
     } while (classCount < 5);    

        //after loop
        student.setGradePoints(gradePointsTot);
        gpa = StudentInfo.getGPA(credits, gpa, classCount);
        student.setGpa(gpa);


        JOptionPane.showMessageDialog(null, student.displayStudentInformation());           
    } 
}

class StudentInfo {
        private String  name;
        private double  totalGradePoints;
        private double  credits;
        private String  grade;
        private double  gpa;

        public StudentInfo(){
            setGrade(null);
            setCredits(0);
            setGradePoints(0);
        }
        public StudentInfo(double credits, double totalGradePoints, String grade){
            setGrade(grade);
            setCredits(credits);
            setGradePoints(totalGradePoints);
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getGrade() {
            return grade;
        }
        public void setGrade(String grade) {
            this.grade = grade;
        }
        public double getCredits() {
            return credits;
        }
        public void setCredits(double credits) {
            this.credits = credits;
        }

        public double getGradePoints() {
            return totalGradePoints;
        }
        public void setGradePoints(double totalGradePoints) {
            this.totalGradePoints = totalGradePoints;
        }

        public double getGpa() {
            return gpa;
        }
        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

        public static double addClass(double totalGradePoints, String grade){
        double gradePoints = 0;
        if(grade.equals("A")){
            gradePoints = 4.0;
        }else if(grade.equals("B")){
            gradePoints = 3.0;
        } else if(grade.equals("C")){
            gradePoints = 2.0;
        } else if(grade.equals("D")){
            gradePoints = 1.0;}
        totalGradePoints = (totalGradePoints +gradePoints);

        return totalGradePoints;
        }

        public static double getGPA(double totalGradePoints, double credits, double gpa){
            gpa = (credits * totalGradePoints)/ credits;
            return gpa;
        }


        public String displayStudentInformation(){
            String output = "";

            output = output + "Name: " + this.getName() + "\n";
            output = output + "Total Credits: " + this.getCredits() + "\n";
            output = output + "Your grade is: " + this.getGrade() + "\n";
            output = output + "Your GPA is: " + this.getGpa() +  "\n";
            output = output + "Press any key to continue!" + "\n";
            output = output + "gp" + this.getGradePoints() + "\n";

            return output;z
        }
}