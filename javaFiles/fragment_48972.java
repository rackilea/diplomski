@Override
public void paint(Graphics g) {

    BufferStrategy bf = this.getBufferStrategy();

    Graphics2D bfg = (Graphics2D) bf.getDrawGraphics();

    bfg.scale(2.0, 2.0);

    mLevel.draw(bfg, this);

    for (GameEntity entity : mGameEntities) {
        entity.step();
        entity.draw(bfg, this);
    }



    bf.show();

}