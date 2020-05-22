game.batch.draw(bucketImage, bucket.x, bucket.y);
for ( Raindrop raindrop : raindrops )
{
    game.batch.draw(raindrop.sprite, raindrop.coordinate.x, raindrop.coordinate.y);
}
game.batch.end();