public class Episode {

    @SerializedName("season")
    @Expose
    private Integer season;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number")
    @Expose
    private Integer number;


    public Integer getSeason() {
        return season;
    }


    public void setSeason(Integer season) {
        this.season = season;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Integer getNumber() {
        return number;
    }


    public void setNumber(Integer number) {
        this.number = number;
    }

 }