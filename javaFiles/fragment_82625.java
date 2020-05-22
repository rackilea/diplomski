public class TowerArcher extends TowerBase {
    // Can't set hp here; the syntax just doesn't work that way.
    // hp = 10;

    public TowerArcher() {
        // Initialize it here, instead.
        // This runs when you construct a TowerArcher.
        hp = 10;
    }
}