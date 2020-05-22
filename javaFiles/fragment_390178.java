public class Cat extends Animal {

    public Cat(String fname, String lname, int size) {
        super(fname, lname, size);
    }

    @Override
    String sound() {
        return "meauvvv";
    }

}