private void didCollisionOccur()
{
    Alien tmpAlien = null;
    PlayerShot tmpPlayerShot = null;
    for(Alien alien : aliens)
    {
        for(PlayerShot playerShot : playerShots)
        {
            if(Intersector.overlaps(alien.getCircle(), playerShot.getCircle()))
            {
                 tmpAlien = alien;
                 tmpPlayerShot = playerShot;
            }
        }
    }
    if(tmpAlien != null && tmpPlayerShot != null)
    {
        aliens.removeValue(tmpAlien,true);
        playerShots.removeValue(tmpPlayerShot,true);
    }
}