import java.util.Random;
import android.media.MediaPlayer;

public class Sounds {

    Context context;
    MediaPlayer cool, good, perfect, sweet, excellent, goodthinking, greatjob,
        notbad, thatstheway, youdidit, yes, again, wrong, sorry,
        sundfornum01, sundfornum02;
    public Random random = new Random();

    public Sounds(Context context){
        this.context = context;
    }

    public void Randomsoundforrightanswer() {
        cool = MediaPlayer.create(context, R.raw.cool);
        good = MediaPlayer.create(context, R.raw.good);
        perfect = MediaPlayer.create(context, R.raw.perfect);
        sweet = MediaPlayer.create(context, R.raw.sweet);
        excellent = MediaPlayer.create(context, R.raw.excellent);
        goodthinking = MediaPlayer.create(context, R.raw.goodthinking);
        greatjob = MediaPlayer.create(context, R.raw.greatjob);
        notbad = MediaPlayer.create(context, R.raw.notbad);
        thatstheway = MediaPlayer.create(context, R.raw.thatstheway);
        youdidit = MediaPlayer.create(context, R.raw.youdidit);
        yes = MediaPlayer.create(context, R.raw.yes);

        switch (random.nextInt(11)) {

            case 0:
                cool.start();
                break;
            case 1:
                good.start();
                break;
            case 2:
                perfect.start();
                break;
            case 3:
                sweet.start();
                break;
            case 4:
                excellent.start();
                break;
            case 5:
                goodthinking.start();
                break;
            case 6:
                greatjob.start();
                break;
            case 7:
                notbad.start();
                break;
            case 8:
                thatstheway.start();
                break;
            case 9:
                youdidit.start();
                break;
            case 10:
                yes.start();
                break;

        }
    }
}