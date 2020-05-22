public class RandomSetGenerator {
public static void main(String[] args) {
    Random generator = new Random();
    for (int i = 0; i < 10; i++) {
        String string = Integer.toString(generator.nextInt(9000) + 1000) + "-" + Integer.toString(generator.nextInt(9000) + 1000) + "-" + Integer.toString(generator.nextInt(9000) + 1000) + "-" + Integer.toString(generator.nextInt(9000) + 1000);
        System.out.println("Specific set of random  number generated :" + string);
    }
}}