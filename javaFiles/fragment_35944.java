public class Player extends Sprite {

    TextureAtlas textureAtlas;

    public Player(TextureAtlas atlas) {
        super(atlas.getRegions().get(0));
        textureAtlas = atlas;
    }

    public void setTexture(String textureName) {
        setRegion(textureAtlas.findRegion(textureName)));
    }

}