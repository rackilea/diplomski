public class SetRows {
    int image;
    String name;
    String id;

    public int getImage () {
        return image;
    }

    public void setImage (int image) {
        this.image = image;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getID () {
        return id;
    }

    public void setID (String id) {
        this.id = id;
    }

    public SetRows(int image, String name, String id) {
        super();
        this.image = image;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return  image + " " + name + " " + id;
    }
}