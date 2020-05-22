public class Randomization {
    public static void main (String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(11);
        System.out.println(randomNumber);
    }
}