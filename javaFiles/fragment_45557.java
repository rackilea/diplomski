public abstract class CharacterClass {

    private int intelligence;
    private int strength;
    private int dexterity;
    private int vitality;

    protected CharacterClass() {
        setIntelligence(10);
        setStrength(10);
        setDexterity(10);
        setVitality(10);
    }

    public int getDexterity() {
        return dexterity;
    }
    protected void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
    public int getVitality() {
        return vitality;
    }
    protected void setVitality(int vitality) {
        this.vitality = vitality;
    }
    public int getStrength() {
        return strength;
    }
    protected void setStrength(int strength) {
        this.strength = strength;
    }
    public int getIntelligence() {
        return intelligence;
    }
    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

}