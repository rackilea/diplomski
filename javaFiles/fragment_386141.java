public void update(){ 
    sprite = new Sprite(this);
    if (gameOver != true) { 
        for (int i = 0; i < numberofsprites; i++) 
        { 
        sprite = spritesArrayList.get(i);
        sprite.update();
        }  
    } 
}