public class Animal {
    public String country;
    public String commonName;
    public Animal(String name, String country) {
        this.country = country;
        commonName = name;
    }
    public String toString() {
        return String.format("%s,%s",commonName,country);
    }
    public static void main(String[] args) {
        Animal animal = new Animal("Emu", "Australia");
        System.out.println("Animal Test");
        System.out.println(animal);
    }
}