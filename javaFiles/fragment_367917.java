public class Paddle extends Sprite {

    private boolean moveUp ;
    private boolean moveDown ;

    // ...

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp ;
        updateVy();
    }

    public void setMoveDown(booleam moveDown) {
        this.moveDown = moveDown ; 
        updateVy();
    }

    private void updateVy() {
        setvY(
            (moveUp ? -PADDLE_SPEED : 0) +
            (moveDown ? PADDLE_SPEED : 0) 
        );
    }

    // ...
}