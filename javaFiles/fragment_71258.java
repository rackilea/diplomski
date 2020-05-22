@Override
public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
    if(pSceneTouchEvent.isActionDown()) { //Jump only if the user tapped, not moved his finger or something
        final Entity playerEntity = ...;//Get player entity here.

        final float jumpDuration = 2;
        final float startX = playerEntity.getX();
        final float jumpHeight = 100;

        final MoveYModifier moveUpModifier = new MoveYModifier(jumpDuration / 2, startX, startX - jumpHeight); // - since we want the sprite to go up.
        final MoveYModifier moveDownModifier = new MoveYModifier(jumpDuration / 2, startX + jumpHeight, startX);
        final SequenceEntityModifier modifier = new SequenceEntityModifier(moveUpModifier, moveDownModifier);

        playerEntity.registerEntityModifier(modifier);
        return true;
    }
    return false;
}