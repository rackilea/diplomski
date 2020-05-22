public class SentenceScreen implements Screen {
public SentenceScreen(Game g) {
    game = g;
}

@Override
public void render(float delta) {
// TODO Auto-generated method stub
Gdx.gl.glClearColor(0,0,0,0);
Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

stage.act(delta);
stage.draw();
}

@Override
public void show() {

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
}
}