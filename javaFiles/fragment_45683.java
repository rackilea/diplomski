//render() method  

sourceX+=10;      
batch.begin();          
batch.draw(texture, 0, 0, sourceX, 0, (int) background.getWidth(), (int) background.getHeight());
batch.end();
stage.act(Gdx.graphics.getDeltaTime());
stage.draw();