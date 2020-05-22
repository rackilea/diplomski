public class PositionedTexture {
public Texture Texture;
public Vector2 Position;

public PositionedTexture(String texturePath) {
    Texture = new Texture(Gdx.files.internal(texturePath));
    Position = Vector2.Zero;
}

public PositionedTexture(String texturePath, Vector2 position) {
    Texture = new Texture(Gdx.files.internal(texturePath));
    Position = position;
}