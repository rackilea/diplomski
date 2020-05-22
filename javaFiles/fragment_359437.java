public class Playlist {

   private String name;
    public Playlist (String name) {
        this.name = name;
    }

    public String getName() {
    return name;
}

    @Override
    public String toString() {
        return "Playlist [name=" + name + "]";
    }
}