public class User {
    private UserDetails userDetails;
    private Image image;

    public User(UserDetails userDetails, Image image) {
        this.userDetails = userDetails;
        this.image = image;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public Image getImage() {
        return image;
    }

}