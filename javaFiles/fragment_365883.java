import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("album")
    @Expose
    private List<Album> album = null;

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public class Song {

        @SerializedName("id_song")
        @Expose
        private String idSong;
        @SerializedName("track")
        @Expose
        private String track;

        public String getIdSong() {
            return idSong;
        }

        public void setIdSong(String idSong) {
            this.idSong = idSong;
        }

        public String getTrack() {
            return track;
        }

        public void setTrack(String track) {
            this.track = track;
        }

    }
    public class Album {

        @SerializedName("id_album")
        @Expose
        private String idAlbum;
        @SerializedName("name_album")
        @Expose
        private String nameAlbum;
        @SerializedName("song")
        @Expose
        private List<Song> song = null;

        public String getIdAlbum() {
            return idAlbum;
        }

        public void setIdAlbum(String idAlbum) {
            this.idAlbum = idAlbum;
        }

        public String getNameAlbum() {
            return nameAlbum;
        }

        public void setNameAlbum(String nameAlbum) {
            this.nameAlbum = nameAlbum;
        }

        public List<Song> getSong() {
            return song;
        }

        public void setSong(List<Song> song) {
            this.song = song;
        }

    }
}