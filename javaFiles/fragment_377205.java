public class Datum {

@SerializedName("image")
@Expose
private String image;
@SerializedName("text")
@Expose
private String text;
@SerializedName("time")
@Expose
private Integer time;
@SerializedName("key")
@Expose
private String key;

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

public String getText() {
return text;
}

public void setText(String text) {
this.text = text;
}

public Integer getTime() {
return time;
}

public void setTime(Integer time) {
this.time = time;
}

public String getKey() {
return key;
}

public void setKey(String key) {
this.key = key;
}

}