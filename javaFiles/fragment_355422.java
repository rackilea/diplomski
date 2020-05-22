class GameScreen extends AbstractScreen {

  Player player;

  public GameScreen(NinjaGame game) {
    super(game);
    init();
  }

  @Override
  protected void init() {
    initPlayer();
  }

  private void initPlayer() {
    player = new Player();
    player.setDebug(true);
    stage.addActor(player);
  }

  @Override
  public void render(float delta) {
    super.render(delta);

    update();
    stage.draw();
  }

  private void update() {
    stage.act();
  }

  @Override
  public void resize(int width, int height){
    stage.getViewport().update(width,height);
  }
}