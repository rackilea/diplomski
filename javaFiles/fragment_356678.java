public class Animal {
    private String name;
    private int age; 

    public Animal(String name, int age) {
       this.name = name;
       this.age = age;
    }

    public String getName() [ return this.name; }
    public int getAge() { return this.age; }
}

public class Bear extends Animal {
    private int weight;

    public Bear(String name, int age, int weight) {
        super(name, age);
        this.weight = weight;
    }

    public int getWeight() { return this.weight; }
}