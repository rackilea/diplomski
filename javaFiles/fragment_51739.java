Action nextAction = Action.Start;
while (action != Action.Quit)
{
    switch (action)
    {
        case Start:
            nextAction = gameStart();
            break;
        case ShowEnd:
            nextAction = gameEnd();
            break;
        // ToDo: write more actions!
        default:
            break;
    }
}