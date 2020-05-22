// In your contact listener
if (BodyUtils.bodyIsBird(a) && BodyUtils.bodyIsBoom(b))
{
    explosion_sound.play();
    removeBody(b);
}
if (BodyUtils.bodyIsBird(b) && BodyUtils.bodyIsBoom(a))
{
    explosion_sound.play();
    removeBody(a);
}

private final Array<Body> toBeRemovedBodies = new Array<Body>();

public void removeBody(Body body)
{
    toBeRemovedBodies.add(body);
}

// After you stepped you world
for(Body body : toBeRemovedBodies)
    world.destroyBody(body);