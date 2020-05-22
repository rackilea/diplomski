public class Person{
    String firstName;
    String middleName;
    String lastName;
    int age;

    public Person(String fName, String lName){
        firstName = fname;
        lastName = lName;
    }

    //Your 4 parameters constructor with the same name
    public Person(String fName, String mName, String, lName, int newAge){
        firstName = fName;
        middleName = mName;
        lastName = lName;
        age = newAge;
    }
}

public class BirthdayBoy extends Person{
    String birthMonth;
    int birthYear;

    public BirthdayBoy(String fName, String lName, String bMonth, int bYear){
        super(fName, lName);
        birthMonth = bMonth;
        birthYear = bYear;
    }

}