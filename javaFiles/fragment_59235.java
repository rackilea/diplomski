public class Post {

    private String postid;
    private String postimage;
    private String description;
    private String publisher;
    private String text_event;
    private String text_location;
    private String text_date_time;
    private Long timestamp;
    private Location locationHelper;

    public Post(String description, String postId, String postImage, String publisher, Long timestamp,
                String text_event, String text_location, String text_date_time, double latitude, double longitude, LocationHelper location) {
        this.postid = postid;
        this.postimage = postimage;
        this.description = description;
        this.publisher = publisher;
        this.text_event = text_event;
        this.text_location = text_location;
        this.text_date_time = text_date_time;
        this.timestamp = timestamp;
        Latitude = latitude;
        Longitude = longitude;
        this.locationHelper = location;
    }

    public Post() {
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPostimage() {
        return postimage;
    }

    public void setPostimage(String postimage) {
        this.postimage = postimage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getText_event() {
        return text_event;
    }

    public void setText_event(String text_event) {
        this.text_event = text_event;
    }

    public String getText_location() {
        return text_location;
    }

    public void setText_location(String text_location) {
        this.text_location = text_location;
    }

    public String getText_date_time() {
        return text_date_time;
    }

    public void setText_date_time(String text_date_time) {
        this.text_date_time = text_date_time;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


    public Location getLocation() {
        return locationHelper;
    }

    public void setLocation(Location location) {
        this.locationHelper = location;
    }
}