public class VibrationManager {

    private static VibrationManager me;
    private Context context;

    Vibrator v = null;

    private Vibrator getVibrator(){
        if(v == null){
            v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
        return v;
    }

    public static VibrationManager getManager(Context context) {
        if(me == null){
            me = new VibrationManager();
        }
        me.setContext(context);
        return me;
    }

    private void setContext(Context context){
        this.context = context;
    }

    public void vibrate(long[] pattern){

    }
}