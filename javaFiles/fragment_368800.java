public class MediaFileExample implements Runnable{

    private MarvinVideoInterface    videoAdapter;
    private MarvinImage             videoFrame;

    public MediaFileExample(){
        try{
            // Create the VideoAdapter used to load the video file
            videoAdapter = new MarvinJavaCVAdapter();
            videoAdapter.loadResource("./res/snooker.wmv");

            // Start the thread for requesting the video frames 
            new Thread(this).start();
        }
        catch(MarvinVideoInterfaceException e){e.printStackTrace();}
    }

    @Override
    public void run() {
        try{
            while(true){
                // Request a video frame
                videoFrame = videoAdapter.getFrame();
            }
        }catch(MarvinVideoInterfaceException e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        MediaFileExample m = new MediaFileExample();
    }
}