public abstract class AbstractBrick extends AbstractObject {

    protected int hitCount;

    public AbstractBrick(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public abstract Color getColor();

    @Override
    protected void dispatchCollisionImpl(AbstractObject other) {
        other.onCollisionWithBrick(this);
    }

    @Override
    protected void onCollisionWithBall(Ball ball) {

    }

    @Override
    protected void onCollisionWithBrick(AbstractBrick ball) {

    }

}

// takes one hit to break
public class SimpleBrick extends AbstractBrick {
    public SimpleBrick() {
        super(1);
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}

// takes two hits to break
public class DoubleBrick extends AbstractBrick {
    public DoubleBrick() {
        super(2);
    }

    @Override
    public Color getColor() {
        if (hitCount == 2)
            return Color.RED;
        else
            return Color.PINK;
    }
}

// never breaks
public class SuperBrick extends AbstractBrick {
    public SuperBrick() {
        super(-1);
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }
}