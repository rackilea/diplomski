public class Main
{
    public static void main(String[] args)
    {
        GameLoop game = new GameLoop();
        game.addScreen(State.START, new StartScreen());
        game.addScreen(State.RUNNING, new RunningScreen());
        //Add other states here
        game.run();
    }
}