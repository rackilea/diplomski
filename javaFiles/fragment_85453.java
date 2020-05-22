public class Weapon
{
    final private int attackBonus;
    final private int accuracyBonus;
    final private int range;

    public Weapon(int attackBonus, int accuracyBonus, int range)
    {
        this.attackBonus = attackBonus;
        this.accuracyBonus = accuracyBonus;
        this.range = range;
    }

    public int getAttackBonus() { return this.attackBonus; }
    public int getAccuracyBonus() { return this.accuracyBonus; }
    public int getRange() { return this.range; }
}