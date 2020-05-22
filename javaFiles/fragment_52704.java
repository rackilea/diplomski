assetManager = new AssetManager();
assetManager.load("gfx/uiskin.json", Skin.class);
assetManager.finishLoading();

ui = new Stage();
textArea = new TextArea("test", assetManager.get("gfx/uiskin.json", Skin.class));
ui.addActor(textArea);