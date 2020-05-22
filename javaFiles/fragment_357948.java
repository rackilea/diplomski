boolean hasBeenTapped = false;

public void update(float delta){

    if (Gdx.input.justTouched())
        hasBeenTapped = true;

    if (hasBeenTapped && getX() < 864)
        setX(getX() + 3f*delta);

}