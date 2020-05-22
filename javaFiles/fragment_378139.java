public class Owner {
@SerializedName("avatar_url")
@Expose
private String avatarUrl;

@SerializedName("login")
@Expose
 private String login;

 public Owner(){}

 public void setAvatarUrl(String avatar_URL){
 this.avatarUrl = avatar_URL;
 }

 pubic String getAvatarUrl(){
 return avatarUrl;
 }

 public String getLogin(){
  return login;
 }

 public void setLogin(String login){
  this.login = login;}
  }

public class Item {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("owner")
    @Expose
    private Owner owner;

     @SerializedName("stargazers_count")
    @Expose
    private int stargazers;
    .........
    }