public class MainRush extends JavaPlugin implements Listener{

    private ScoreboardManager manager;
    private Scoreboard board;

    @Override
    public void onEnable(){
        //plugin enabled
        manager = Bukkit.getScoreboardManager();
        board = manager.getNewScoreboard();
    }
}