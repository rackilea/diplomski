public class Dictonary {

    @SerializedName("users")
    User[] userArray;
    @SerializedName("wordbank")
    Wordbank[] wordbankArray;

    public User[] getUserArray() {
        return userArray;
    }

    public void setUserArray(User[] userArray) {
        this.userArray = userArray;
    }

    public Wordbank[] getWordbankArray() {
        return wordbankArray;
    }

    public void setWordbankArray(Wordbank[] wordbankArray) {
        this.wordbankArray = wordbankArray;
    }
}