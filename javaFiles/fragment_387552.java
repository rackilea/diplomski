public class SomeClass {

    private final TimedRandomNumberGenerator generator = new TimedRandomNumberGenerator(1000);

    private void drawTower() {
        batcher.draw(
            AssetLoader.texture1,
            tower1.getX(), 
            tower1.getY() + tower1.getHeight() - generator.getValue(),
            tower1.getWidth(), midPointY - (tower1.getHeight())
        );    
    }
}