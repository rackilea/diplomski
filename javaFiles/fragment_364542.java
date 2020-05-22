public abstract class AbstractObject {

    ...

    public final void dispatchCollision(AbstractObject other) {
        other.dispatchCollisionImpl(this);
    }

    protected abstract void dispatchCollisionImpl(AbstractObject other);

    protected abstract void onCollisionWithBall(Ball ball);

    protected abstract void onCollisionWithBrick(Brick ball);
}


public class Ball extends AbstractObject {

    ...

    @Override
    protected void dispatchCollisionImpl(AbstractObject other) {
        other.onCollisionWithBall(this); // this is where main "magic" happens
    }

    @Override
    protected void onCollisionWithBall(Ball ball) {
        throw new UnsupportedOperationException("Ball-ball collision should never happen");
    }

    @Override
    protected void onCollisionWithBrick(Brick ball) {
        // your actual brick-ball collision logic
    }

}