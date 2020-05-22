import java.util.Scanner;

class Student
{
public static void main(String[] args)//The main method; starting point of the program.
{
    Scanner input = new Scanner(System.in);

    String surName, foreName, courseName;
    String[] courses = new String[]{};
    int age,telephone;

    System.out.println("\t\t\t***********************************************");    
    System.out.println("\t\t\tWelcome to the Mobile College's Student Records");
    System.out.println("\t\t\t***********************************************");
    System.out.println("\nHow many students would you like to add?");
    int noStudents = input.nextInt();

    Stu [] TheStu = new Stu [noStudents];

    for (int x = 0; x < noStudents; x++)
    {
        System.out.println("Please enter Surname: ");
        surName = input.next();
        System.out.println("Please enter Forename: ");
        foreName = input.next();
        System.out.println("Please enter Age: ");
        age = input.nextInt();
        System.out.println("Please enter Telephone No. ");
        telephone = input.nextInt();
        System.out.println("Which courses do you want to add the student to? .......Literacy or Numeracy or both ");

        courseName = input.nextLine();
        // change to either upper case or lower case for easy treatment
        courseName = courseName.toUpperCase();
        // Also verify that the user entered a valid course name
        if(courseName.equals("LITERACY")){
            courses = new String[]{"LITERACY"};
        } else if(courseName.equals("NUMERACY")){
            courses = new String[]{"NUMERACY"};
        } else if(courseName.equals("BOTH")){
            courses = new String[]{"LITERACY", "NUMERACY"};
        } else{
            System.out.println("Error : You entered an invalid option.... \n This student won't be registered for any courses");
        }

        TheStu [x] = new Stu (surName, foreName, age, telephone, courses);
    }

    for (int y = 0; y < noStudents; y++)
    {
        System.out.println("\t\t\t***********************************************");
        System.out.println ("\t\t\tName: " + TheStu[y].getfName() + " " + TheStu[y].getsName());
        System.out.println ("\t\t\tAge: " + TheStu[y].getstuAge());
        System.out.println ("\t\t\tTelephone No. 0" + TheStu[y].getphone());
        System.out.println ("\t\t\tEnrolled in the following courses : ");
        courses = TheStu[y].getcourseTypes();
        for(int i = 0; i < courses.length; i++){
            System.out.println(courses[i]);
        }
        if(courses.length < 1){
            System.out.println("No Courses");
        }
        System.out.println("\t\t\t***********************************************");
    }

}// end of class
}

class Stu
{
private String sName;
private String fName;
private int stuAge;
private int phone;
private String[] courseTypes;

Stu (String s, String f, int a, int p, String[] c)
{
    sName = s;
    fName = f;
    stuAge = a;
    phone = p;
    courseTypes = c;
}

String getsName()
{
    return sName;
}   

String getfName()
{
    return fName;
}   

int getstuAge()
{
    return stuAge; 
}

int getphone()
{
    return phone; 
}

String[] getcourseTypes()
{
    return courseTypes;
}
}