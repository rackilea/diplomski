package tes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

class Student {

    private String name;
    private String ID;
    private Double gpa;
    public Double getGpa() {
        return gpa;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", ID=" + ID + ", gpa=" + gpa + "]";
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
public class Students {


   public static void main(String[] args) {

       try{


           ArrayList<Student> students = new ArrayList<Student>();
           Scanner scanner = new Scanner(System.in);
           System.out.print("Enter filename: "); //prompt the user for the file name
           String fileName = scanner.next();
           File file = new File(fileName);

            if (!file.exists()) {
                throw new FileNotFoundException("file not exits");
            }

            BufferedReader reader = new BufferedReader(new FileReader(file)); 
            String currentline = "";
            while ((currentline = reader.readLine()) != null) {

                String[] linearray = currentline.split(",");
                for (int i=0;i<linearray.length;i++) {
                        String record = linearray[i];
                        String[] r1 = record.split(" ");
                        Student student = new Student();
                        student.setName(r1[0]);
                        student.setID(r1[1]);
                        student.setGpa(Double.parseDouble(r1[2]));
                        students.add(student);
                }

            }       

            System.out.println(students);



        }catch(Exception e){
            e.printStackTrace();
        }

      }
}