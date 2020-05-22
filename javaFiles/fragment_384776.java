public class EnemyActor extends Actor implements Damageable, Physical {

    private final DamageableActorDecoration damageDecorator;
    private final PhysicalActorDecoration physicalDecorator;

    public EnemyActor() {
        damageDecorator = new DamageableActorDecoration(this);
        physicalDecorator = new PhysicalActorDecoration(this);
    }

    @Override
    public void applyDamage(float dmg) {
        damageDecorator.applyDamage(dmg);
    }

    @Override
    public boolean isDestroyed() {
        return damageDecorator.isDestroyed();
    }

    @Override
    public void applyGravity() {
        physicalDecorator.applyGravity();
    }
}

public class Actor {
    int posX;
    int posY;
    boolean visible = true;
}

public interface Damageable {
    void applyDamage(float dmg);

    boolean isDestroyed();
}

public class DamageableActorDecoration implements Damageable {
    float health = 10;
    private final Actor base;

    public DamageableActorDecoration(Actor base) {
        this.base = base;
    }

    @Override
    void applyDamage(float dmg) {
        health -= dmg;
        if (health <= 0)
            base.visible = false;
    }

    @Override
    boolean isDestroyed() {
        return health <= 0;
    }
}

public interface Physical {
    void applyGravity();
}

public class PhysicalActorDecoration implements Physical {
    private final Actor base;

    public PhysicalActorDecoration(Actor base) {
        this.base = base;
    }

    @Override
    public void applyGravity() {
        base.posY--;
    }
}