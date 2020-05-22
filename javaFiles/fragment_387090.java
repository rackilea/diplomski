interface Spell {
    int getCooldown();
    String getName();
    void cast();
}

public class Ice implements Spell {
    @Override
    public int getCooldown() { . . . }
    @Override
    public String getName() { . . . }
    @Override
    public void cast() { . . . }
    // more stuff specific to Ice
}
public class Hurricane implements Spell {
    // similar to above
}