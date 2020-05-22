public class ExploreModel {
    private String title, description, imageUrl, location;

    public ExploreModel() {}

    public ExploreModel(String title, String description, String imageUrl, String location) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.location = location;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public String getLocation() { return location; }
}