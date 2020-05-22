public class ClickableFont {

//Declare the fields
private GlyphLayout layout;
private BitmapFont font;

private String text;

private int posX;
private int posY;

/**
 * Constructs clickable text from a font
 * @param text Text to display
 * @param posX X position of the text
 * @param posY Y position of the text
 */
public ClickableFont(String text, int posX, int posY) {
    this.text = text;
    this.posX = posX;
    this.posY = posY;

    font = new BitmapFont(Gdx.files.internal("arial-15.fnt"));
    layout = new GlyphLayout(font, text);

}

/**
 * @param batch Draws the text using the given SpriteBatch.
 * @param camera Requires a camera to calculate touches between screen and world.
 */
public void update(SpriteBatch batch, OrthographicCamera camera)
{
    checkClicked(camera);

    font.draw(batch, layout, posX, posY);
}

/**
 * Checks if this object is clicked and outputs to console
 * @param camera the camera
 */
private void checkClicked(OrthographicCamera camera)
{
    if (Gdx.input.justTouched())
    {
        //Get screen coordinates
        Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        //Transform screen touch to world coordinates using the camera you are drawing with
        camera.unproject(touch);

        //System.out.println(getRectangle());
        //System.out.println(touch);

        if (getRectangle().contains(touch.x, touch.y))
        {
            System.out.println(text + " has been clicked.");
        }
    }
}

/**
 * Creates a rectangle for the sprite to perform collision calculations.
 * Since it seems font.draw draws from top to bottom (coordinate system of LibGDX is not consistent)
 * We have to adept the rectangle position Y position
 * @return rectangle of font bounds
 */
private Rectangle getRectangle()
{
    return new Rectangle(posX, posY - (int)layout.height, (int)layout.width, (int)layout.height);
}
}