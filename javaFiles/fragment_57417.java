public class Result {

    private String user_id;
    private String item_id;
    private String name;
    private String price;
    private String description;
    private String created_at;
    private ThumbnailModel thumbnail; 
    public String getUser_id() {
        return user_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public ThumbnailModel getThumbnail() {
        return thumbnail;
    }

    @Override
    public String toString() {
        return "Result [user_id=" + user_id + ", item_id=" + item_id
                + ", name=" + name + ", price=" + price + ", description="
                + description + ", created_at=" + created_at + ", thumbnail="
                + thumbnail + "]";
    }

}