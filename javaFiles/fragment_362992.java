float interpolationTimer = 0.0f;
final float interpolationTimerMax = 2.0f;

public void render()
{
    float delta = Gdx.graphics.getDeltaTime();
    interpolationTimer += delta;
    if(interpolationTimer > interpolationTimerMax )
    {
        interpolationTimer = interpolationTimerMax ;
    }
    velocity.y = -200 + (interpolationTimer/interpolationTimerMax) * (400); //x1 + t*v = x2
    projectile.y -= velocity.y * delta;
}