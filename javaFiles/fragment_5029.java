Button botonTest = new Button(new Skin(Gdx.files.internal("skin/uiskin.json")));
    botonTest.setPosition(50f, 50f);

    MoveToAction move = new MoveToAction();

    move.setPosition(-10f, 50f);
    move.setDuration(5f);

    botonTest.addAction(move);