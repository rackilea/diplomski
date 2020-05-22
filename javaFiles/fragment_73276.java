public class Person {

    private int age, weight, height;
    private String name;
    private gender aGender;

    public enum gender {
        MALE, FEMALE
    }

    public Person(int age, int weight, int height, String name, gender aGender) {
                 this.age = age;
        this.weight = weight;
        this.height = height;
        this.name = name;
        this.aGender = aGender;
    }
}