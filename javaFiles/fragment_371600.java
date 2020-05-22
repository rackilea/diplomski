public class MainResponse {

    @SerializedName("races")
    @Expose
    private List<Race> races = null;

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

}