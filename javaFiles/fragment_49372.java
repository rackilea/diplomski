public class Data {

@SerializedName("restaurant_id")
@Expose
private Integer restaurantId;
@SerializedName("restaurant_name")
@Expose
private String restaurantName;
@SerializedName("logo")
@Expose
private String logo;
@SerializedName("rate")
@Expose
private String rate;
@SerializedName("price")
@Expose
private Integer price;
@SerializedName("is_open")
@Expose
private Boolean isOpen;
@SerializedName("address")
@Expose
private String address;
@SerializedName("image")
@Expose
private String image;

public Integer getRestaurantId() {
return restaurantId;
}

public void setRestaurantId(Integer restaurantId) {
this.restaurantId = restaurantId;
}

public String getRestaurantName() {
return restaurantName;
}

public void setRestaurantName(String restaurantName) {
this.restaurantName = restaurantName;
}

public String getLogo() {
return logo;
}

public void setLogo(String logo) {
this.logo = logo;
}

public String getRate() {
return getValue(rate);
}

public void setRate(String rate) {
this.rate = rate;
}

public Integer getPrice() {
return price;
}

public void setPrice(Integer price) {
this.price = price;
}

public Boolean getIsOpen() {
return isOpen;
}

public void setIsOpen(Boolean isOpen) {
this.isOpen = isOpen;
}

public String getAddress() {
return getValue(address);
}

public void setAddress(String address) {
this.address = address;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

}