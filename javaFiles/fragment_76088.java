Gdx.input.setInputProcessor(stage);
//If you want multiple input processors you need to use a InputMultiplexer

InputMultiplexer im = new InputMultiplexer();
im.addProcessor(stage);
im.addProcessor(new GestureDetector(someScreen));
im.addProcessor(player.getInputProcessor);