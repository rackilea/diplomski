public class Music {

    private String songTitle;
    private double songLength;
    private int rating;

    public Music(String songTitle, double songLength, int rating) {
        this.songTitle = songTitle;
        this.songLength = songLength;
        this.rating = rating;

    }

    public String getsongTitle() {
        return songTitle;
    }

    public double getsongLength() {
        return songLength;
    }

    public int rating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Music{" + "songTitle=" + songTitle + ", songLength=" + songLength + ", rating=" + rating + '}';
    }
}