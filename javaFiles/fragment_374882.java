@ManagedBean
@SessionScoped
public class GameBeans {
    private int randomNumber;
    private int userGuess;
    private int gamesPlayed;

    public GameBeans() {
        Random number     = new Random();
        this.randomNumber = number.nextInt(1000);
        this.gamesPlayed  = 0;
    }

    public void getWin() {
        if (this.userGuess.equals(this.randomNumber)) 
             return "Congratulations! You've Won!";
        else return "You Lose!";
    }

    public void incrementGamesPlayed() {
        this.gamePlayed++;
    }

    // Getters and Setters
}