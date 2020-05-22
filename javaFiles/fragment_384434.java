public void gotoScreen(Screens screen)
{
    System.gc();
    if (screen == screen.MAIN)
    {
        super.setScreen(new Main(this));
    }

    if (screen == screen.START_SCREEN)
    {
        super.setScreen(new StartScreen(this));
    }

    if (screen == screen.CASUAL_LEVEL)
    {
        super.setScreen(new CasualLevel(this));
    }

    if (screen == screen.NORMAL_LEVEL)
    {
        super.setScreen(new NormalLevel(this));
    }

    if (screen == screen.HARDCORE_LEVEL)
    {
        super.setScreen(new HardcoreLevel(this));
    }

    if (screen == screen.CREDITS)
    {
        super.setScreen(new Credits(this));
    }
}