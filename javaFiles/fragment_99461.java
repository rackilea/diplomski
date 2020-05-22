// scale and move a sprite over 2 seconds
Timeline tl = Timeline.createSequence().
    .push(Tween.set(spr, SpriteAccessor.SCALE).target(1, 1))
    .push(Tween.set(spr, SpriteAccessor.POSITION).target(0, 0))
    .beginParallel()
        .push(Tween.to(spr, SpriteAccessor.SCALE, 2).target(2, 2))
        .push(Tween.to(spr, SpriteAccessor.POSITION, 2).target(50, 50))
    .end()
    .start(tweenManager);

// force the animation to complete
tl.update(2);
// no need to call kill() as isFinished gets set implicitly by the update