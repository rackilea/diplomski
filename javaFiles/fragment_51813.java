public class SpriteMapObject extends MapObject {

    private Sprite sprite;

    public SpriteMapObject (Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public Color getColor () {
        return sprite.getColor();
    }

    @Override
    public void setColor(Color color){
        sprite.setColor(color);
    }

    public void render(Batch batch){
        Color spriteColor = sprite.getColor();
        float originalAlpha = spriteColor.a;
        spriteColor.a *= getOpacity();
        sprite.draw(batch);
        spriteColor.a = originalAlpha;
    }
}