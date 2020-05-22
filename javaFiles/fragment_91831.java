public class Person {

    String name;
    int age;
    boolean isMan;

    Person(String name, int age, boolean isMan) {
        this.name = name;
        this.age = age;
        this.isMan = isMan;
    }

    public void showInfo() {
        System.out.println("Име: " + this.name + " | " + "години: " + this.age + " | " + "мъж ли е: " + this.isMan);
    }

    // SETTERS and GETTERS
}