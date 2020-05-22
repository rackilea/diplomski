public class Kata {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        return fighter2.name.equals(firstAttacker)
            ? fight(fighter2, fighter1)
            : fight(fighter1, fighter2);
    }

    private static String fight(Fighter firstFighterToAttack, Fighter secondFighterToAttack) {
        ... // fight logic
    }
}