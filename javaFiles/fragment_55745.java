public void paintComponents (Graphics g)
{

    for(Bullet j : GameState.getEnBullets()){
        g.drawImage(j.getImage(),j.getX(), j.getY(), null);}
    for(Enemy j : GameState.getEnemies()){
        g.drawImage(j.getImage(),j.getX(), j.getY(), null);}
    for(Bullet j : GameState.getPlayBullets()){
        g.drawImage(j.getImage(),j.getX(), j.getY(), null);}
    this.paint(g);

}