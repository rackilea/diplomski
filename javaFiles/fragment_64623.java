public class ResourcesHandler {
    private static ResourcesHandler handlerObj;
    private Context mContext;
    private GraphicsCollection mGraphics;
    private SoundFxPlayer mSoundFx;
    private MusicPlayer mMusic;

    private ResourcesHandler(){
        //TODO
    }

    public static ResourcesHandler getInstance() {
        if (handlerObj == null){
            handlerObj = new ResourcesHandler();
        }
        return handlerObj;
    }

    public void unload(){
        mContext=null;
        if(null != mGraphics){
          mGraphics.unload();
        }
        if(null != mSoundFx){
          mSoundFx.unload();
        }
        if(null != mMusic){
          mMusic.unload();
        }                           
    }
}