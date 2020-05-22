static float speed = 30; // move speed outside method to not create it each frame.

private void playerMovement() {
    if(Gdx.input.isKeyPressed(Input.Keys.W)){
        body.setLinearVelocity(0f, speed); // removed Vector2(), it's not a good idea to cteate it each frame.
    }if(Gdx.input.isKeyPressed(Input.Keys.S)){
        body.setLinearVelocity(0f, -speed);
    }if(Gdx.input.isKeyPressed(Input.Keys.A)){
        body.setLinearVelocity(-speed, 0f);
    }if(Gdx.input.isKeyPressed(Input.Keys.D)){
        body.setLinearVelocity(speed,0f);
    }if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)){
        body.setLinearVelocity(-speed, speed);
    }if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)){
        body.setLinearVelocity(speed, speed);
    }if(Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A)){
        body.setLinearVelocity(-speed, -speed);
    }if(Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)){
        body.setLinearVelocity(speed, -speed);
    }else {
        body.setLinearVelocity(0f,0f);
    }
}