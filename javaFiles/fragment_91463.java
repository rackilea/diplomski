public class simple  implements ApplicationListener {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    //folowing are not nececary anymore since it's handled by the new class
    //BitmapFont font; 
    //GlyphLayout layout; 
    //String a1 = "aa";
    //String a2 = "bb";
    //String a3 = "cc";

    int a = 0;

    //Declare a list to hold your clickable fonts
    List<ClickableFont> clickableFonts = new ArrayList<ClickableFont>();

    @Override
    public void create() {
      camera = new OrthographicCamera();
      camera.setToOrtho(false, 800, 480);
      batch = new SpriteBatch();

    //Add clickable fonts to the list
      clickableFonts.add(new ClickableFont("aa", 200, 200));
      clickableFonts.add(new ClickableFont("bb", 200 + 150, 200));
      clickableFonts.add(new ClickableFont("cc", 200 + 150 * 2, 200));
   }

   @Override
   public void render() {
      Gdx.gl.glClearColor(0, 0, 0.2f, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);    
      camera.update();
      batch.setProjectionMatrix(camera.combined);
      batch.begin();
      /* replace your loop
      for (int i =1; i< 4;i++){ 
          layout.setText(font, "a"+i);
          font.draw(batch, layout,200+(15*i),200 );
      }*/
      for (ClickableFont font : clickableFonts)
      {
          font.update(batch, camera);
      }
      batch.end();  
  }