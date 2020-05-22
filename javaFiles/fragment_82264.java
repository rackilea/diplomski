public class MainGame extends Game {

    SpriteBatch spriteBatch;
    BitmapFont font[];
    OrthographicCamera camera;

    @Override
    public void create() {

        camera=new OrthographicCamera();
        camera.setToOrtho(false,400,640);
        spriteBatch = new SpriteBatch();

        int size[]=new int[]{5,8,10,13,15,20,30,40,50,60};

        font=new BitmapFont[size.length];
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("BUBBLEGUM.TTF"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.color = Color.WHITE;
        parameter.magFilter = Texture.TextureFilter.Linear; // used for resizing quality
        parameter.minFilter = Texture.TextureFilter.Linear;

        for(int i=0;i<size.length;i++){
            parameter.size=size[i];
            font[i]=generator.generateFont(parameter);
            font[i].getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            font[i].setColor(1.0f, 0.0f, 0.0f, 1.0f);
        }

        generator.dispose();   // Don't forget to dispose
    }

    @Override
    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1,1,0,1);

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        for (int i=0;i<font.length;i++)
           font[i].draw(spriteBatch,"LIBGDX FONT",10,100+i*55);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
         camera.setToOrtho(false,width,height);
    }

    @Override
    public void dispose() {
         spriteBatch.dispose();
         for(BitmapFont bmfont:font)
              bmfont.dispose();

    }
}