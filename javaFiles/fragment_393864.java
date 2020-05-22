com.example.jacob.wutk;

        import android.media.AudioManager;
        import android.media.MediaPlayer;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;

        import java.io.IOException;

public class radio extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean isMediaPlayerStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        setMediaPlayer();
    }

    public void setMediaPlayer() {
        try {
            mediPlayer = new MediaPlayer();
            String url = "http://streamer.cci.utk.edu:8000/wutk-vorbis"; 

            ImageButton imb = (ImageButton) findViewById(R.id.playPause);

            imb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isMediaPlayerStarte) {
                        mediaPlayer.prepareAsync();
                        isMediaPlayerStarted = true;
                    } else {
                        if (mediaPlayer.isPlaying()) {
                            imb.setImageResource(R.drawable.play1);
                            mediaPlayer.pause();
                        } else {
                            imb.setImageResource(R.drawable.pause1);
                            mediaPlayer.start();
                        }
                    }
                }
            });

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}