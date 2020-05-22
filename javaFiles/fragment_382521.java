public class PostModel  {       
    String id;
    Bitmap image; //whatever your image is
    String text;

    public PostModel(String id, Bitmap image, String text) {
        this.id = id;
        this.image = image;
        this.text = text;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Bitmap getImage() {
        return image;
    }
    public void setImage(Bitmap image) {
        this.image = image;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}