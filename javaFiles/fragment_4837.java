public class MTest extends Mammal {
public static void main(String args[]) {
    Mammal m = new Mammal();
    try {
        m.takeDamage(-100);
    } catch(Exception e) {
        System.out.println("Exception");
    }
}