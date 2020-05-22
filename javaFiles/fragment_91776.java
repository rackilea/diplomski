public interface PaintableEntity {
    public void paint(Graphics2D g2d, double progress);
}

public class AstroidEntity implements PaintableEntity {

    private SpriteSheet spriteSheet;
    private Point location;
    private double angel;

    public AstroidEntity(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
        location = new Point(0, 0);
        angel = 0;
    }

    public void update() {
        // Apply movement and rotation deltas...
    }

    public void paint(Graphics2D g2d, double progress) {
        g2d.drawImage(
                spriteSheet.getSprite(progress), 
                location.x, 
                location.y, 
                null);
    }

}