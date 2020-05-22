public class Utilities {
    public static void myPop(Context context){
        MediaPlayer pop = MediaPlayer.create(context, R.raw.pop);
        pop.start();
    }
}