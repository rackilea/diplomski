public void handleInput(Application app)
{
    if (input.touchDown)
    {
        unprojectedTouchPos.set(input.screenTouchPos);
        app.viewport.unproject(unprojectedTouchPos);
        position.x = unprojectedTouchPos.x - sprite.getWidth() / 2;
    }
}