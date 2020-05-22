public class Person {
    static ArrayList<Person> people = new ArrayList<>();
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        people.add(this);
    }

    public void display() {
        System.out.println(name + ", age " + age);
    }

    public static void displayAll() {
        for (int i=0; i<people.size(); i++) {
            people.get(i).display();
        }
    }
}