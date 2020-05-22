package eduard.alarmamotivationala;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] cards = {R.drawable.i1, R.drawable.i2, R.drawable.i3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   initializing the image view
        ImageView m_imgRandom = (ImageView) findViewById(R.id.imgRandom);
        //   choosing a random number from 0 to 2
        int n = new Random().nextInt(3);
        //   choosing the random image from cards array using the random number
        m_imgRandom.setImageResource(cards[n]);

    }
}