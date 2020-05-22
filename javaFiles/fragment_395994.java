manager=new AssetManager();
FileHandleResolver resolver = new InternalFileHandleResolver();
manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

FreetypeFontLoader.FreeTypeFontLoaderParameter parms = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
parms.fontFileName = path;    // path of .ttf file where that exist 
parms.fontParameters.size = 10;
manager.load(fileName, BitmapFont.class, parms);   // fileName with extension, sameName will use to get from manager

manager.finishLoading();  //or use update() inside render() method