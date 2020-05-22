public class Serial {

    @SerializedName("episodes")
    @Expose
    private List<Episode> episodes = new ArrayList<Episode>();
    @SerializedName("year")
    @Expose
    private Integer year;

    public List<Episode> getEpisodes() {
        return episodes;
    }


    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }


    public Integer getYear() {
        return year;
    }


    public void setYear(Integer year) {
        this.year = year;
    }

 }