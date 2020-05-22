import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class MusicBox {

private HashMap<String, Music> music;
private HashMap<String, Sound> sounds;

public MusicBox() {
    music = new HashMap<String, Music>();
    sounds = new HashMap<String, Sound>();
}

public void loadMusic(String path) {
    int slashIndex = path.lastIndexOf('/');
    String key;
    if(slashIndex == -1) {
        key = path.substring(0, path.lastIndexOf('.'));
    }
    else {
        key = path.substring(slashIndex + 1, path.lastIndexOf('.'));
    }
    loadMusic(path, key);
}
public void loadMusic(String path, String key) {
    Music m = Gdx.audio.newMusic(Gdx.files.local(path));
    music.put(key, m);
}
public Music getMusic(String key) {
    return music.get(key);
}
public void removeMusic(String key) {
    Music m = music.get(key);
    if(m != null) {
        music.remove(key);
        m.dispose();
    }
}
public void removeAll() {
    for(Object o : music.values()) {
        Music music = (Music) o;
        music.dispose();
    }
    music.clear();
    for(Object o : sounds.values()) {
        Sound sound = (Sound) o;
        sound.dispose();
    }
    sounds.clear();
}

}