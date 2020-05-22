public class Character {
    protected int hitPoints;
    public int getHitPoints(){return hitPoints;}

}

public class subCharacter extends Character {
    public subCharacter () {
        hitPoints = 100;
    }
}