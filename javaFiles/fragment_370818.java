Entity playerEntity = ..//It doesn't matter if the player is a sprite, animated sprite, or anything else. So I'll just use Entity here, but you can declare your player as you wish.

final float jumpDuration = 2;
final float startX = playerEntity.getX();
final float jumpHeight = 100;

final MoveYModifier moveUpModifier = new MoveYModifier(jumpDuration / 2, startX, startX + jumpHeight);
final MoveYModifier moveDownModifier = new MoveYModifier(jumpDuration / 2, startX + jumpHeight, startX);
final SequenceEntityModifier modifier = new SequenceEntityModifier(moveUpModifier, moveDownModifier);

playerEntity.registerEntityModifier(modifier);