public void run()
{
    displayWelcomeMessage();
    getUserName();
    greetUser();

    if(getAnswer()) //User wants to play!
    {
        do
        {
            intNumberGuessGame();
        } while (mPlayAgainInput != DO_NOT_PLAY_AGAIN);

        sayGoodbye();
    }
}