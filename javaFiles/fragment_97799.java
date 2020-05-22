public class DiceRolls {
    static void recurse(int diceNumber, int[] values, final int MAX) {
        if (diceNumber == values.length) {
            System.out.println(java.util.Arrays.toString(values));
        } else {
            for (int v = 1; v <= MAX; v++) {
                values[diceNumber] = v;
                recurse(diceNumber + 1, values, MAX);
            }
        }
    }
    public static void main(String[] args) {
        recurse(0, new int[3], 4);
    }
}