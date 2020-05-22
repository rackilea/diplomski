static class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id; this.name = name;
    }

    public String toString() {
        return String.format("%d - %-21s*", id, name);
    }
}

public static void main (String[] args) throws java.lang.Exception
{
    Person[] people = { 
        new Person(1, "Bill Gates"),
        new Person(2, "Trump"),
        new Person(3, "Tail"), 
        new Person(4, "James Bond")
    };

    for (Person p : people) {
        System.out.println(p);
    }
}