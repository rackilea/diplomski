import java.util.*;

public class Yahtzee {

    ArrayList<Die> savedDice = new ArrayList<Die>();

    // Constructor

    public Yahtzee() {
    }

    // renamed method to avoid confusion
    public void rollDice(int num) {
        Die[] dice = new Die[num];
        for (int d = 0; d < dice.length; d++) {
            Die nextDie = new Die();
            nextDie.roll();
            dice[d] = nextDie;
        }

        saveDice(dice);
    }

    public void saveDice(Die[] dice) {
        // int array will count occurrences of each face value
        int[] values = new int[] { 0, 0, 0, 0, 0, 0 };
        for (Die d : dice) {
            values[d.getVal() - 1]++;
        }
        int most = -1;
        int temp = 0;
        for (int j = 0; j < values.length; j++) {
            if (values[j] >= temp) {
                most = j + 1;
                temp = values[j];
            }
        }

        // Thought something like this looked much cleaner than having conditions for each value.
        if (temp > 1) {
            System.out.println("You have " + temp + " " + most + "'s");
        } else {
            System.out.println("No dice are the same. We kept " + most
                + " because it's the largest face value.");
        }

        for (Die d : dice) {
            if (d.getVal() == most) {
                savedDice.add(d);
            }
        }
    }

}