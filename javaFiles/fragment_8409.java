@XmlRootElement(name = "Game")
@XmlAccessorType(XmlAccessType.FIELD)
public class Game {
    @XmlElement(name="GameTitle")
    private String gameTitle;

    @XmlElementWrapper(name="Genres")
    @XmlElement(name="genre")
    private List<String> genres;

    public List<String> getGenres() {
        return genres;
    }


    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
}