public class Main extends Activity {

private Button playButton, rulesButton, aboutButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);

    playButton = (Button) findViewById(R.id.button_play);
    rulesButton = (Button) findViewById(R.id.button_rules);
    aboutButton = (Button) findViewById(R.id.button_about);
}

public void playGame(View v) {
    switch (v.getId())
    {
        case R.id.button_play:
            Intent intent = new Intent(Main.this, OpenGLActivity.class);
            startActivity(intent);
            break;
        case R.id.button_rules:
            Intent intent = new Intent(Main.this, DetailsActivity.class);
            startActivity(intent);
            break;
    }

}