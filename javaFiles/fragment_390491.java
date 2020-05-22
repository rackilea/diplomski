import java.util.Scanner;
public class Library extends Student{
public static void main(String[] args) {
    Student record = new Student();
    int roll;
    String name;
    int mob;
    int i;

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter roll numer of student \n");
    roll = sc.nextInt();
    System.out.println("Enter name of the student \n");
    name = sc.next();
    System.out.println("Enter mobile number of the student \n");
    mob = sc.nextInt();

    record.getData(roll, name, mob);

record.showData();
}
}
public class Student
{
 int roll;
String name;
int mob;
int i = 0;

void getData(int roll, String name, int mob) {

    this.roll = roll;
    this.name = name;
    this.mob = mob;

}

void showData() {

    //for(i=0; i < 3; i++)
System.out.println("roll number " + roll + "\nname " +  name + "\nmobile number " + mob);
}
}