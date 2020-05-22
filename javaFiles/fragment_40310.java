private String base64String = null;
private String base64Type = "png";

public String getBase64Image() {
    if(this.base64String != null) {
        return "data:image/" + this.base64Type + ";base64," + this.base64String;
    } else {
        return null;
    }
}