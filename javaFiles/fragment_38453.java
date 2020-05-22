private void Respawn(){
    if(bBody[0] != null && bBody[0].getPosition().x <= -3){

        minWorldY = pigeoncam.position.y - pigeoncam.viewportHeight/2;
        maxWorldY = pigeoncam.position.y + pigeoncam.viewportHeight/2;
        randomYPos =  MathUtils.random(minWorldY, maxWorldY);
        bBody[0].setTransform(7, randomYPos, 0);

    }
}