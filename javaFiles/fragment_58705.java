for (Rectangle raindrop : raindrops)
{
    for (int i = 0; i < sprites.length - 1; i++)
    {
        // The following will draw ALL sprites at the same location!
        game.batch.draw(sprites[i], raindrop.x, raindrop.y);
    }
}