List<IWeapon> weapons = new List<IWeapon>();
weapons.Add(new Weapon(new Reloadable());
weapons.Add(new Weapon(new Unreloadable());

//Call weapon[0].replenish and weapon[1].replenish will have different behavior in this way.

public class Reloadable implements IReloadable {
    public void replenish (final int amount){
        //Do something.
    }
}

public class Unreloadable implements IReloadable {
    public void replenish (final int amount){
        //Maybe tell the player that he cannot reload with this weapon.
    }
}

public final class Weapon implements GameItem, IWeapon {
    IReloadable _reloadable;

    public Weapon(IReloadable reloadable){
        _reloadable = reloadable;
    }

    public void replenish (final int amount){
        _reloadable.replenish(amount);
    }
}