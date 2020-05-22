public class LoadingScreen implements Screen{
    final MyGdxGame game;

    public LoadingScreen(final MyGdxGame gam){
        game = gam;

        FileHandleResolver resolver = new InternalFileHandleResolver();
        game.assets.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        game.assets.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        FreeTypeFontLoaderParameter size1Params = new FreeTypeFontLoaderParameter();
        size1Params.fontFileName = "Fonts/calibri.ttf";         
        size1Params.fontParameters.genMipMaps = true;                   
        size1Params.fontParameters.minFilter = TextureFilter.Linear;
        size1Params.fontParameters.magFilter = TextureFilter.Linear;                        
        size1Params.fontParameters.size = Gdx.graphics.getWidth()/18;
        game.assets.load("font1.ttf", BitmapFont.class, size1Params);

        FreeTypeFontLoaderParameter size2Params = new FreeTypeFontLoaderParameter();
        size2Params.fontFileName = "Fonts/calibri.ttf";         
        size2Params.fontParameters.genMipMaps = true;                   
        size2Params.fontParameters.minFilter = TextureFilter.Linear;
        size2Params.fontParameters.magFilter = TextureFilter.Linear;                        
        size2Params.fontParameters.size = Gdx.graphics.getWidth()/6;
        game.assets.load("font2.ttf", BitmapFont.class, size2Params);
    }

}