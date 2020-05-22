public class Axe extends Weapon
{

    public Axe(GameEngine parentGameEngine)
    {
        super(parentGameEngine);
    }

    public boolean getItemUsable()
    {
        return true;
    }

    public String getObjectName()
    {
        return "Axe";
    }

    public String getItemVisual()
    {
        return "4 foot long handle with a very sharp blade.";
    }

    public int getMinAttackDamage()
    {
         // fill in
    }

    public int getMaxAttackDamage()
    {
         // fill in
    }

    public String getAttackVisual(Character attacker, Character attacked, Room attackLocation)
    {
         // fill in
    }
}