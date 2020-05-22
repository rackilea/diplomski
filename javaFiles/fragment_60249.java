//for drawing the player
public void paintImg(Entity e, Graphics g){ //polymorphism
    g.drawImage(e.img(), e.LocX(), e.LocY(), null);
}

public void playerPaint(Graphics g){
    g.drawImage(image, model.getPlayerX(), model.getPlayerY(), null); //creates the user
}