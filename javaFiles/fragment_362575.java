batch = new SpriteBatch();
    skin = new Skin(Gdx.files.internal("data/uiskin.json"));
    stage = new Stage();

    final TextButton button = new TextButton("Click me", skin, "default");

    button.setWidth(400f);
    button.setHeight(100f);
    button.setPosition(Gdx.graphics.getWidth() / 2 - 100f, Gdx.graphics.getHeight() / 2 - 10f);

    button.addListener(new ChangeListener() {
        @Override
        public void changed(ChangeEvent event, Actor actor) {
            Gdx.gl.glClearColor(1, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }
    });
    stage.addActor(button);

    Gdx.input.setInputProcessor(stage);