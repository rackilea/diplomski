import java.sql.SQLException;
    import java.util.Scanner;

public class Football {

    public static void main(String[] args) throws SQLException, Exception {

        Scanner in= new Scanner(System.in);
        String name,education;
        int age;

            SimpleExample s=new SimpleExample();
        System.out.println("Enter your name:");
        name=in.next();
        s.setName(name);
        System.out.println("Enter you Age");
        age=in.nextInt();
        s.setAge(age);
        System.out.println("Enter your Education");
        education=in.next();
        s.setEducation(education);
        s.insert();     

    }

}