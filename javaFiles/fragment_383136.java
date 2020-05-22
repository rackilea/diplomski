import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private MediaPlayer mediaPlayer;
    private ImageView playImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.anthem);
        playImageView = (ImageView) findViewById(R.id.playImageView);

        playImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mediaPlayer.start();
            }
        });
    }
}