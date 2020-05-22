public class Example {

@SerializedName("id")
@Expose
private String id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("description")
@Expose
private String description;
@SerializedName("images")
@Expose
private List<Image> images = null;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public List<Image> getImages() {
return images;
}

public void setImages(List<Image> images) {
this.images = images;
}

}
-----------------------------------com.example.Image.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

@SerializedName("id")
@Expose
private String id;
@SerializedName("title")
@Expose
private Object title;
@SerializedName("link")
@Expose
private String link;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public Object getTitle() {
return title;
}

public void setTitle(Object title) {
this.title = title;
}

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

}