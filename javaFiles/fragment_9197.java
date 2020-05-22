counter -= Gdx.graphics.getDeltaTime();

if(counter <= 3 && counter > 2) {   
    stage.addActor(oneImg);
} else if(counter <= 2 && counter > 1) {
    stage.addActor(twoImg);
} else if(counter <= 1 && counter > 0)  {
    stage.addActor(splashImg);
}