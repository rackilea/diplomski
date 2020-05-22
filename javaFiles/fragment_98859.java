public class GameScreen implements Screen{

    final MrJetpack game;

    OrthographicCamera camera;
    SpriteBatch batch;
    ShapeRenderer rend;
    private Array<SpriteRaindrop> raindrops;

    Texture enemy1,enemy2,enemy3,enemy4,endScreen;
    TextureRegion[] enemys = new TextureRegion[4];

    private int random;


    public GameScreen(final MrJetpack game){

this.game = game;

camera = new OrthographicCamera();
camera.setToOrtho(false, 800, 480);

enemy1  = new Texture(Gdx.files.internal("boxk.png"));
enemy2  = new Texture(Gdx.files.internal("boxg.png"));
enemy3  = new Texture(Gdx.files.internal("kugel.png"));
enemy4  = new Texture(Gdx.files.internal("kugelk.png"));

enemys[0] = new TextureRegion(enemy1);      
enemys[1] = new TextureRegion(enemy2);    
enemys[2] = new TextureRegion(enemy3);     
enemys[3] = new TextureRegion(enemy4); 

raindrops = new Array<SpriteRaindrop>();

rend = new ShapeRenderer();
batch = new SpriteBatch();

   }


   @Override
   public void render(float delta) {
     // TODO Auto-generated method stub
//Gdx.gl.glClearColor(0, (float)148/255,(float) 255/255, 1);
  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
  camera.update();




  batch.setProjectionMatrix(camera.combined);
  rend.begin(ShapeType.Filled);
  rend.rect(0, 0, 800, 10);
  rend.rect(0, 160, 800, 10);
  rend.rect(0, 320, 800, 10);
  rend.setColor(Color.ORANGE);
  rend.end();

  batch.begin();

  for(SpriteRaindrop raindrop: raindrops) {
      //raindrop.translatex(-10f);
      //what is raindrop.y value
      raindrop.updateR();
      raindrop.draw(batch);
   }

  batch.end();


  if(TimeUtils.nanoTime() - lastDropTime > spawnTime){
      spawnRaindrop();  
  }

  Iterator<SpriteRaindrop> iter = raindrops.iterator();

  while(iter.hasNext()) {

     SpriteRaindrop raindrop = iter.next();

     raindrop.translateX(-20f * Gdx.graphics.getDeltaTime());

         if(raindrop.getX() < 0) {
             spawnRaindrop();
             iter.remove();
         }
 }


 }


  private void spawnRaindrop() {

      stages = MathUtils.random(1, 3);
      random = MathUtils.random(0, 3);

      lastDropTime = TimeUtils.nanoTime();

      SpriteRaindrop raindrop = new SpriteRaindrop(enemys[random],
                                                   30, 53, 
                                                   800, 0);
      raindrops.add(raindrop);
     }