public class Dog implements Comparable<Dog> {
    private String name;
    private String breed;
    private String registrationNumber;

    public Dog(String name, String breed, String registrationNumber) {
        this.name = name;
        this.breed = breed;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public int compareTo(Dog dog) {
        if (dog == null) return 1;

        if (this.registrationNumber == dog.registrationNumber) return 0;

        return this.registrationNumber > dog.registrationNumber ? 1 : -1;
    }
}