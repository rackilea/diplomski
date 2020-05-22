private void run()
{
    // ...
        while(unprocessedTime > frameTime)
        {
            // ...
            game.update();
            // ...
        }
        if(render)
        {
            render();
            frames++;
        }
        // ...
}

private void render()
{
    RenderUtil.clearScreen();
    game.render();
    Window.render();
}