public class MainActivity extends AndroidApplication implements GameHelperListener, ActionResolver {
    private GameHelper gameHelper;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new TutorialLibgdxGameservices(this), false);
    if (gameHelper == null) {
      gameHelper = new GameHelper(this, GameHelper.CLIENT_GAMES);
      gameHelper.enableDebugLog(true);
    }
    gameHelper.setup(this);
    }

    @Override
    public void onStart(){
        super.onStart();
        gameHelper.onStart(this);
    }

    @Override
    public void onStop(){
        super.onStop();
        gameHelper.onStop();
    }

    @Override
    public void onActivityResult(int request, int response, Intent data) {
        super.onActivityResult(request, response, data);
        gameHelper.onActivityResult(request, response, data);
    }

    @Override
    public boolean getSignedInGPGS() {
        return gameHelper.isSignedIn();
    }

    @Override
    public void loginGPGS() {
        try {
            runOnUiThread(new Runnable(){
                public void run() {
                    gameHelper.beginUserInitiatedSignIn();
                }
            });
        } catch (final Exception ex) {
        }
    }

    @Override
    public void submitScoreGPGS(int score) {
        Games.Leaderboards.submitScore(gameHelper.getApiClient(), "CgkI6574wJUXEAIQBw", score);
    }

    @Override
    public void unlockAchievementGPGS(String achievementId) {
      Games.Achievements.unlock(gameHelper.getApiClient(), achievementId);
    }

    @Override
    public void getLeaderboardGPGS() {
      if (gameHelper.isSignedIn()) {
        startActivityForResult(Games.Leaderboards.getLeaderboardIntent(gameHelper.getApiClient(), "CgkI6574wJUXEAIQBw"), 100);
      }
      else if (!gameHelper.isConnecting()) {
        loginGPGS();
      }
    }

    @Override
    public void getAchievementsGPGS() {
      if (gameHelper.isSignedIn()) {
        startActivityForResult(Games.Achievements.getAchievementsIntent(gameHelper.getApiClient()), 101);
      }
      else if (!gameHelper.isConnecting()) {
        loginGPGS();
      }
    }

    @Override
    public void onSignInFailed() {
    }

    @Override
    public void onSignInSucceeded() {
    }
}