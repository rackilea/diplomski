public void playerMovement (Variables vars)
{
    if (RightKeyPressed && !collisionRight) {
        vars.x += vars.speed;
    }
}