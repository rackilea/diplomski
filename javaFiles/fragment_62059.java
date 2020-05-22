public class Foo {
    private MediaPlaye md;

    private Foo () {
        md = new MediaPlayer();
    }

    public MediaPlayer getMediaPlayer () {
        if (md == null) {
            new Foo();
        }
        return md;
    }
}