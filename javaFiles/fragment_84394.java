public class Player {
    private Slime slime;
    private static final int ATTACK = 10; // or something

    public void setSlime(Slime slime) {
        this.slime = slime;
    }

    public void attack() {
        int dmg = ATTACK;
        slime.HP -= dmg;
    }
}