public class Bat extends Animal<Bat> {
    public Bat() {
        super(Bat.class);
    }

    private void fly() {
        setChild(Bat.class); // or initiate();
        child.fly();
    }
}