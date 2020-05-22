public class Demo {
    public static void main(String[] args) {
        Animal a = new Dog();
        OutsideWorld.soundTwice(a);
        a = new Cat();
        OutsideWorld.soundTwice(a);
    }
}