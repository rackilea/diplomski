public class Button {

    [Rectangle, Texture, Screen]
    Runnable r;

    public Button(screen, rectangle, texture) {...}

    public void setAction(Runnable r) { this.r = r; }

    public void act() { r.run(); }
}