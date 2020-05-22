@Override
public void show() {
    batch = new SpriteBatch();
    World world = new World();
}


@Override
public void render(float delta){
    int type = 0;
    batch.begin();
    for (int y = 1; y < world.getlengthy();y++){
        for (int x = 1; x < world.getlengthx();x++){
        type = world.getvalue(x, y);


        switch (type) {
            case 1:
                sprite = new Sprite(tex1,0,0,16,16);
                sprite.setPosition(x, y);
                sprite.draw(batch);
                Gdx.app.log("", "x: " + x + " y: " + y);
            break;
            case 2:
                batch.draw(tex2, x, y);
            break;
            case 3:
                batch.draw(tex3, x, y);
            break;
            case 4:
                batch.draw(tex4, x, y);
            break;
            case 5:
                batch.draw(tex5, x, y);
            break;
            case 6:
                batch.draw(tex6, x, y);
            break;
            case 7:
                batch.draw(tex7, x, y);
            break;
            case 8:
                batch.draw(tex8, x, y);
            break;
            }
        }
        batch.end();
}