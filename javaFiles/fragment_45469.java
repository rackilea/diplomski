public class GamePlay extends BasicGameState{

    DrawMap map;    
    ...

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        map.render(gc.getGraphics());
    }
    ...
}