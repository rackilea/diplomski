interface Visitor<T> {
    visit(Set<T> items);
}

interface MusicVisitor extends Visitor<Music>;

class MusicLibrary {
    private Set<Music> collection ...
    public void accept(MusicVisitor visitor) {
       visitor.visit( this.collection );
    }
}

class RockMusicVisitor implements MusicVisitor {
    private final Set<Music> picks = ...
    public visit(Set<Music> items) { ... }
    public Set<Music> getRockMusic() { return this.picks; }
}
class AmbientMusicVisitor implements MusicVisitor {
    private final Set<Music> picks = ...
    public visit(Set<Music> items) { ... }
    public Set<Music> getAmbientMusic() { return this.picks; }
}