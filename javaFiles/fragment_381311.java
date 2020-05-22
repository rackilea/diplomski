class Student { 
    int marks; 
    String name; 
    char sex; 
    String email;
    public void setName(String string)
    {
        // TODO Auto-generated method stub

    } 
}


public class StudentDemo{
    public static void main(String [] args)
    {
    Student s[] = new Student[10];// array Student//
    Student s1  = new Student();//  Student Object//
    s1.setName("John"); //Eclipse says here there is a mistake an ask to delete John// 
    s[0]=s1;
    }
}