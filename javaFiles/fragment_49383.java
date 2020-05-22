public class Battle {

    private double attackValue = 0;
    private double defenseValue = 0;

    public Battle (Attacker attacker, Defender defender) {
        attackValue = attacker.getATKtype();
        defenseValue = defender.getDEFtype();
    }

    public void result() {
        if (attackValue == defenseValue) {
            System.out.println("Block");
        } else if (attackValue > defenseValue) {
            System.out.println("Hit");
        } else { // attack is lower than defense
            // do what you need for that
        }
    }

}