package assignments;

public class RollDice {

    public static void main(String[] args) {

        final int rollCount = 10000;

        Dice die1 = new Dice();
        Dice die2 = new Dice();

        int die1Number;
        int die2Number;

        int dieTotal = 0;

        for (int count = 0; count < rollCount ; count++) {
            die1.Roll();
            die1Number = die1.getNumbers();

            die2.Roll();
            die2Number = die2.getNumbers();

            dieTotal += die1Number + die2Number; 
        }

        System.out.println(dieTotal);
    }
}