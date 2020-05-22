public class YourClass {

    /* Oher stuff here */

    private Random random;

    public YourClass() {
        // ...
        random = new Random();
    }

    public boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    /* More stuff here */

}