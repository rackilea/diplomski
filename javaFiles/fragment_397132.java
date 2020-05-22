public class Person {

    private final String fisrtName;
    private final String lastName;
    private final int age;
    private final int dob;

    public Person(String fisrtName, String lastName, int age, int dob) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.age = age;
        this.dob = dob;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getDob() {
        return dob;
    }

}