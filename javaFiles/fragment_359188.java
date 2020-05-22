import java.util.Random;

/**
 *
 * @author Tyler Weaver
 */
public class DiceGame {
    private int cash;
    private Random gen;

    public DiceGame(final int cash) {
        this.cash = cash;
        gen = new Random();
    }

    public int roll() {
        return gen.nextInt(6) + 1;
    }

    public void calcCash(final int sum) {
        cash += (sum == 7) ? 4 : -1;
    }

    public int getCash() {
        return cash;
    }
}