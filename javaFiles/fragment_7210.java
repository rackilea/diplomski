@XmlRootElement
public class Root {

    private List<Game> listGame;

    @XmlElement(name="game")
    public List<Game> getListGame() {
        return listGame;
    }

    public void setListGame(List<Game> listGame) {
        this.listGame = listGame;
    }
}