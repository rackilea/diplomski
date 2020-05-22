public class Assets implements Disposable {

    public AssetManager assetManager;

    public Assets(){

        assetManager=new AssetManager();   
    }

    ...

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}