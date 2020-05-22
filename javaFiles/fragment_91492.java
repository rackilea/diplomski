private void didCollisionOccur()
{
    for(Alien alien : aliens)
    {
        for(PlayerShot playerShot : playerShots)
        {
            if(Intersector.overlaps(alien.getCircle(), playerShot.getCircle()))
            {
                aliens.removeValue(alien,true);
                playerShots.removeValue(playerShot,true);
            }
        }
    }
}