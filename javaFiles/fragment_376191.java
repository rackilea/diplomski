public void update(float dt){
    if (velocity.x == 0) 
        velocity.x = SP; //first frame setup

    //only change the velocity if character is off screen, otherwise leave it alone
    if (position.x > 2560)
        velocity.x = NSP;
    else if (position.x < 0 - texture.getWidth())
        velocity.x = SP;

    position.add(velocity.x * dt, 0, 0);
}