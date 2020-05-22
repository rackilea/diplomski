public class GameLoop
{
    private State state = State.START;
    private Map<State, Screen> screens = new HashMap<>();

    public void addScreen(State state, Screen screen)
    {
        screens.put(state, screen);
    }

    public void run()
    {
        Screen screen = screens.get(state);
        screen.handleInput();
        screen.update();
        screen.draw();
    }
}