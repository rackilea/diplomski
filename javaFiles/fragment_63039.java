public class LevelScene extends Scene<LevelHandler> {
    @Override
    public void render(Graphics g) {
        super(g);
        handler.doLevelOnlyThing();
    }
}