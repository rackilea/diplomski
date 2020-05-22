public final class AndroidMuteCtrl{

    static Context myContext;
    // Called From C# to get the Context Instance
    public static void receiveContextInstance(Context tempContext) {
        myContext = tempContext;
    }

    public static String debugThis()
    {
        return "Test message from AndroidMuteCtrl plugin.";
    }

    public static boolean isMuted()
    {
        AudioManager audio = myContext.getSystemService(Context.AUDIO_SERVICE);
        if (audio.getRingerMode() ==  AudioManager.RINGER_MODE_NORMAL) return false;
        else  return  true;
    }
}