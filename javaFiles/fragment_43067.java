public class GameView extends SurfaceView {
    private MainActivity mActivity;

    //Create new constructor to get the Activity
    public GameView(Activity activity) {
        super(activity);
        mActivity = (MainActivity) activity;
    }

    private void gameOver(){
        mActivity.gameOverUi();
    }
}