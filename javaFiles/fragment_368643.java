float velX = 0, velY = 0;
    if(Gdx.input.isKeyPressed(Input.Keys.W)) {
        velY = 2.0f ;
    } else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
        velX = 2.0f;
    } else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
        velY = -2.0f;
    } else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
         = -2.0f;
    }

    player.getBody().setLinearVelocity(x, y);