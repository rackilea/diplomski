public class Accordo implements Serializable {
int image;
String name;
String note;

public String getNote() {
    return note;
}

public void setNote(String note) {
    this.note = note;
}

public Accordo(int image, String name, String note) {
    this.image = image;
    this.name = name;
    this.note=note;
}

public int getImage() {
    return image;
}

public void setImage(int image) {
    this.image = image;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
}