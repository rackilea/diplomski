public class Button {

    public Rectangle r;
    public TextureRegion image;

    private MyScreen screen;
    private ButtonValues b;

    public Button(MyScreen screen, Rectangle r, TextureRegion image, ButtonValues b) {
        this.screen = screen;
        this.r = r;
        this.image = image;
        this.b = b;
    }

    public void act() {
        screen.buttonPressed(b);
    }

    public boolean isClicked(float x, float y) {
        return x > r.x && y > r.y && x < r.x + r.width && y < r.y + r.height;
    }
}