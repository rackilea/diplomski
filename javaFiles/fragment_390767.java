public class Playlist {
    private Song firstSong;
    private Song secondSong;
    private Song thirdSong;

    public void setSong(Song song) {
        if (song != null) {
            if (firstSong == null) {
                firstSong = song;
            } else if (secondSong == null) {
                secondSong = song;
            } else if (thirdSong == null) {
                thirdSong = song;
            }
        }
    }
}