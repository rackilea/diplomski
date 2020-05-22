@Override
public void show() {
 manaer=new AssetManager();
    batch = new SpriteBatch();

    manager.load("Image/splash.PNG",Texture.class);
    manager.finishLoading();
    Texture splashTexture = manager.get("Image/splash.PNG",Texture.class);
    splash = new Sprite(splashTexture);
    splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

}