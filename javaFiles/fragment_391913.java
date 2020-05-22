class ScreenOneRows implements ItemInterface{
String sequence_id;
String sequence_description;
String sequence_image;
String sequence_title;

public String getSequence_id() {
    return sequence_id;
}

public void setSequence_id(String sequence_id) {
    this.sequence_id = sequence_id;
}

public String getSequence_description() {
    return sequence_description;
}

public void setSequence_description(String sequence_description) {
    this.sequence_description = sequence_description;
}

public String getSequence_image() {
    return sequence_image;
}

public void setSequence_image(String sequence_image) {
    this.sequence_image = sequence_image;
}

public String getSequence_title() {
    return sequence_title;
}

public void setSequence_title(String sequence_title) {
    this.sequence_title = sequence_title;
}

@Override
public boolean isRow() {
    return true;
}
}