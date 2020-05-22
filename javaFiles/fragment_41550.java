collision = false; 
for(int i = 0; i < bullets.length; i++){
    if(playerRectangle.intersects(bullet[i].getBulletRectangle())){
        collision = true;
}
//perform whatever you want to happen if bullet collides with player