public class Game extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        downloadSong();
    }

    public void downloadSong(){
        String stringUrl = "some link";
        new DownloadSong(this).execute(stringUrl);
    }
}