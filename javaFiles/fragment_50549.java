public class MovieResponse {
    @SerializedName("show")
    @Expose
    private Movie show;

    public Movie getShow() {
        return show;
    }
}