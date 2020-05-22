public void run()
{
    switch(state)
    {
    case START:
        //DRAW THE START SCREEN
        break;
    case RUNNING:
        //DRAW THE GAME
        break;
    case PAUSE:
        //DRAW THE PAUSE SCREEN
        break;
    case GAME_OVER:
        //DRAW THE GAME OVER SCREEN
        break;
    default:
        throw new RuntimeException("Unknown state: " + state);
    }
}