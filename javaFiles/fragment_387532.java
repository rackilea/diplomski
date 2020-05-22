public class WPPostResponse {
    @JsonAlias("featured_media")
    Long featuredMedia;

    public Long getFeaturedMedia() {
        return featuredMedia;
    }

    public void setFeaturedMedia(Long featuredMedia) {
        this.featuredMedia = featuredMedia;
    }
}