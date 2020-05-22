//create:
fitViewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
extendViewport = new ExtendViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);

//resize:
fitViewport.update(width, height);
extendViewport.update(width, height);

//render:

fitViewport.apply();
batch.setProjectionMatrix(fitViewport.getCamera().combined);
batch.begin();
//draw game
batch.end();

extendViewport.apply();
batch.setProjectionMatrix(extendViewport.getCamera().combined);
batch.begin();
//draw stuff in border
batch.end();