public class MenuScreen implements Screen {

  public MenuScreen(Main game) {
     ViewPort viewPort=new ExtendViewport(Constants.APP_WIDTH,Constants.APP_HEIGHT);
     this.stage = new Stage(viewPort);
     this.game = game;
     this.sb = game.sb;
     setHeadline();
  }

  private void setHeadline() {
     atlas = new TextureAtlas(Gdx.files.internal(Constants.HEADLINES_IMAGE_ATLAS_PATH));
     stage.addActor(new Headline(atlas.findRegion(Constants.MENUHEADLINE_REGION_NAMES)));
  }

  @Override
  public void resize(int width, int height) {
    stage.getViewport().update(width,height);
  }
}