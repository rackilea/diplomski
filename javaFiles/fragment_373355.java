public class Speedys {

    @SerializedName("factionId")
    private String factionId;

    @SerializedName("lastLoginTime")

    private int lastLoginTime;


      public String getFactionId() {
        return factionId;
    }

    public void setFactionId(String factionId) {
        this.factionId = factionId;
    }
public int getlastLoginTime() {
        return lastLoginTime;
    }

    public void setlastLoginTime(int lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }