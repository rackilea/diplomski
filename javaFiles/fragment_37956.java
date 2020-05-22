public class Movie {

    public enum Genre {
        Horror,
        SciFi,
        RomCom
    };

    protected Genre genre;

    public Movie(Genre g) {
        this.genre = g;
    }
}