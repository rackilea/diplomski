public static AssetManager manager;

public static void load()
{   
    manager = new AssetManager();
    manager.load(spriteAtlas);
    manager.load(uiAtlas);
    manager.load(uiSkin);
    manager.load(defaultFont);
    manager.load(mediumFont);
}