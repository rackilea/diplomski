stage = new Stage();

Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

btnLogin = new TextButton("Click me", skin);
btnLogin.setPosition(300, 50);
btnLogin.setSize(100, 60);
stage.addActor(btnLogin);

textField = new TextField("", skin);
textField.setPosition(100, 50);
textField.setSize(190, 60);
stage.addActor(textField);

Gdx.input.setInputProcessor(stage);