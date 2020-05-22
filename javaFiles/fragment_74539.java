public class DogTest {
    public static void main(String[] args) {
        Dog dogA = new Dog(7, 10, "abcdefghijklmnopqrstuvwxyz");

        String state = dogA.save();
        System.out.println(state); // #0007#0010#abcd^efgh^ijkl^mnop^qrst^uvwx^yz#

        Dog dogB = new Dog().load(state);
        System.out.println(dogB); // Dog [age=7, type=10, name=abcdefghijklmnopqrstuvwxyz]
    }
}