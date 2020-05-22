import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("Users")
    User user;
    @SerializedName("Status") int status;
    @SerializedName("Description") String description;
}