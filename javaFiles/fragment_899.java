public class Piece {

    private Image image;
    private String name;

    public Piece(String name, Image image) {
        this.image = image;
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

}