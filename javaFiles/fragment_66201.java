public class ExploreModel {
    private String title, description, imageUrl, location;

    public ExploreModel() {}

    public ExploreModel(String title, String description, String imageUrl, String location) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.location = location;
    }

    @PropertyName("mTitle")
    public String getTitle() { return title; }
    @PropertyName("mDescription")
    public String getDescription() { return description; }
    @PropertyName("mImageUrl")
    public String getImageUrl() { return imageUrl; }
    @PropertyName("mLocation")
    public String getLocation() { return location; }
}