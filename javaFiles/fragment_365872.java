public class Person {

    private String name;
    private MyDate birthday; // This is a date based on a Person's birthday 
    private MyDate today; // A date based on today's date

    public Person(String name, int day, int month, int year) {
        this(name, new MyDate(day, month, year)); 
    }

    public Person(String name) {
        this(name, today());
    }

    public Person(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

}