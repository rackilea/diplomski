public class SpellTooltip {

    private Map<Class<? extends Spell>, Spell> templates = new HashMap<>();

    {
        templates.put(Firebolt.class, new Firebolt());
        templates.put(Frostbolt.class, new Frostbolt());
    }

    public int getSpellDamage(Class<? extends Spell> clazz) {
        return templates.get(clazz).getDmg();
    }
}