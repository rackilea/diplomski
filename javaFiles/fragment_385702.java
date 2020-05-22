@Override
public void create() {
    AssetManager.getInstance().initialize("core/assets/test.json");
    AssetManager.getInstance().load("group 1");
    AssetManager.getInstance().finishLoading();
    System.out.println("SUCCESS!");
    Texture texture = AssetManager.getInstance().get("core/assets/badlogic.jpg", Texture.class);

    System.out.println("Texture"+texture);

    ScreenManager.getInstance().initialize(this);
    ScreenManager.getInstance().setScreen(ScreenEnum.SPLASH);
}