//Member variable:
float totalTime = 5 * 60; //starting at 5 minutes

void render(){
    float deltaTime = Gdx.graphics.getDeltaTime(); //You might prefer getRawDeltaTime()

    totalTime -= deltaTime; //if counting down

    int minutes = ((int)totalTime) / 60;
    int seconds = ((int)totalTime) % 60;

    //...
}