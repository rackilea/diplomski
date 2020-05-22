public class Dog extends Animal {

    public Dog(String fname, String lname, int size) {
        super(fname, lname, size);
    }

    @Override
    String sound() {
        return "bark";
    }

}