long id;
...
public void create() {
    music = Gdx.audio.newSound(Gdx.files.internal("soundtrack.ogg"));
    id = music.loop(); //Sound may not be ready here!
}

public void render() {
    if(id == -1)
        id = music.loop();
}