if(!turn){          
        bug.translate(v.x * Gdx.graphics.getDeltaTime(), v.y * Gdx.graphics.getDeltaTime());
    }
    else{
        bug.translate(-(v.x * Gdx.graphics.getDeltaTime()), -(v.y * Gdx.graphics.getDeltaTime()));
    }

    //REMOVE THIS LINE
    bug.translate(v.x * Gdx.graphics.getDeltaTime(), v.y * Gdx.graphics.getDeltaTime());