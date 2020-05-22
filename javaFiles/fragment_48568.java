public class CompilationAlbum extends Album {

    private String seriesOfAlbums;

    public CompilationAlbum(String seriesOfAlbums) {
        this.seriesOfAlbums = seriesOfAlbums;
        albumType = "Compilation";
    }
}