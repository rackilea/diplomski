public void AddEnemyToScreen(int enemy_count)
{

    // As long as enemy count is positive, keep adding enemies.
    if ( enemy_count > 0) {
             // Add new enemy to screen
            AddEnemey(new Enemy(r.nextInt(640), -10, textures,this,game));
            AddEnemyToScreen(enemy_count-1); // Add one more            
    }

}