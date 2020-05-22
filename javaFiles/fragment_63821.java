Timeline.createSequence()
.push(Tween.set(cuptop1, SpriteAccessor.ALPHA).target(0).start(tweenManager))
.push(Tween.set(cuptop2, SpriteAccessor.ALPHA).target(0).start(tweenManager))

.push(Timeline.createParallel()
    .push(Tween.to(cuptop1, SpriteAccessor.ALPHA,0.5f).delay(0.5f).target(1).start(tweenManager))
    .push(Tween.to(cuptop2, SpriteAccessor.ALPHA,0.5f).delay(0.3f).target(1).start(tweenManager))   
    )

.pushPause(1)

.push(Timeline.createParallel()
    .push(Tween.to(cuptop1, SpriteAccessor.POS_XY, 1.0f).target(10,10).ease(TweenEquations.easeNone).start(tweenManager))
    .push(Tween.to(cuptop2, SpriteAccessor.POS_XY, 1.0f).target(20,20).ease(TweenEquations.easeNone).start(tweenManager))
    )

.pushPause(1)

.push(Timeline.createParallel()
    .push(Tween.to(cuptop1, SpriteAccessor.POS_XY, 1.0f).target(100,100).ease(TweenEquations.easeNone).start(tweenManager))
    .push(Tween.to(cuptop2, SpriteAccessor.POS_XY, 1.0f).target(200,200).ease(TweenEquations.easeNone).start(tweenManager))
    )

.start(tweenManager);