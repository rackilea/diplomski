public class Gdx_Game_Android extends AndroidApplication  {
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
    config.useAccelerometer = false;
    config.useCompass = false;
    config.useGL20 = true;
    initialize(new Gdx_game(this), config);
}
}